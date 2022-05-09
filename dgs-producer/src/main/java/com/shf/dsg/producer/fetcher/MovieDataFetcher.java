package com.shf.dsg.producer.fetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataLoader;
import com.shf.dsg.producer.entity.Director;
import com.shf.dsg.producer.entity.Movie;
import com.shf.dsg.producer.loader.DirectorsDataLoader;
import com.shf.dsg.producer.service.DirectorService;
import com.shf.dsg.producer.service.MovieService;
import graphql.schema.DataFetchingEnvironment;
import org.dataloader.BatchLoader;
import org.dataloader.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * description :
 *
 * @author songhaifeng
 * @date 2022/5/8 19:17
 */
@DgsComponent
public class MovieDataFetcher {
    @Autowired
    DirectorService directorService;

    @Autowired
    MovieService movieService;

    /**
     * BatchLoader接口仅提供了一个方法，是标准的function，故其可以直接通过lambda方式实例化，其等价于{@link DirectorsDataLoader}
     */
    @DgsDataLoader(name = "directors2")
    public BatchLoader<Integer, Director> directorBatchLoader = ids -> CompletableFuture.supplyAsync(() -> directorService.loadDirectors(ids));

    /**
     * 获取movie集合，当前mock场景下movieService仅能获取id和name字段信息，无法获取director字段信息，其依赖{@link DirectorService}
     * <pre>{
     *   listMovies {
     *     id
     *     name
     *     director {
     *       id
     *       name
     *     }
     *   }
     * }</pre>
     *
     * @return list of {@link Movie}
     */
    @DgsData(parentType = "Query", field = "listMovies")
    public List<Movie> listMovies() {
        return movieService.listAll();
    }

    /**
     * 在{@link MovieDataFetcher#listMovies()}方法中，movieService无法获取director字段信息。
     * 一旦请求中解析到来源于{@link Movie}的director字段，则其会通过当前dataFetcher获取对应的数据，故此处parentType为schema中定义的Movie类型。
     * 此方法会针对每个movie对象独立调用，故当有N个movie实例时会被调用N次。
     * 为了提高整体性能，通过dataLoader即可实现batchLoader能力，将N个movie对应的director信息一次性获取，从而解决N+1问题。
     * 更多N+1说明可查看{@link DirectorsDataLoader}类描述
     *
     * @param dfe DataFetchingEnvironment
     * @return {@link Director}
     */
    @DgsData(parentType = "Movie", field = "director")
    public CompletableFuture<Director> director(DataFetchingEnvironment dfe) {
        DataLoader<Integer, Director> dataLoader = dfe.getDataLoader("directorsWithTry");
        // 当前source为Movie对象
        Movie movie = dfe.getSource();
        // dataLoader收集所有movieId后执行{@link DirectorsDataLoader#load}批量获取集合数据
        return dataLoader.load(movie.getId());
    }

}
