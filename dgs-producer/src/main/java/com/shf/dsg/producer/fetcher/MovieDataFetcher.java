package com.shf.dsg.producer.fetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsDataLoader;
import com.shf.common.entity.Director;
import com.shf.common.entity.Movie;
import com.shf.dsg.producer.loader.DirectorsDataLoader;
import com.shf.dsg.producer.service.DirectorService;
import com.shf.dsg.producer.service.MovieService;
import graphql.execution.DataFetcherResult;
import graphql.schema.DataFetchingEnvironment;
import org.dataloader.BatchLoader;
import org.dataloader.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

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
        DataLoader<Integer, Director> dataLoader = dfe.getDataLoader("directors");
        // 当前source为Movie对象
        Movie movie = dfe.getSource();
        // dataLoader收集所有movieId后执行{@link DirectorsDataLoader#load}批量获取集合数据
        return dataLoader.load(movie.getId());
    }


    /**
     * 此示例演示如何通过{@link DataFetcherResult}构造带有localContext上下文的嵌套结构查询场景。
     *
     * @return DataFetcherResult
     */
    @DgsData(parentType = "Query", field = "listMoviesWithLocalContext")
    public DataFetcherResult<List<Movie>> listMoviesWithLocalContext() {
        List<Movie> movies = movieService.listAll();
        return DataFetcherResult.<List<Movie>>newResult()
                .data(movies)
                .localContext(movies.stream()
                        .collect(Collectors.toMap(m -> m, Movie::getId)))
                .build();
    }

    /**
     * 当前获取{@link Director}方式即为one by one，是典型的N+1场景。
     * 如下即通过LocalContext上下文获取{@link MovieDataFetcher#listMoviesWithLocalContext()}中传递的信息，并进行后续操作的示例。
     *
     * @param dfe
     * @return
     */
    @DgsData(parentType = "Movie2", field = "director")
    public CompletableFuture<Director> director(DgsDataFetchingEnvironment dfe) {
        Map<Movie, Integer> movieMap = dfe.getLocalContext();
        Movie movie = dfe.getSource();
        return CompletableFuture.completedFuture(directorService.loadDirector(movieMap.get(movie)));
    }

    /**
     * 通过{@link DataFetchingEnvironment#getSelectionSet()}定向获取投影字段，
     * 然后批量获取对应数据集存储在localContext中达到preLoad效果，并在{@link MovieDataFetcher#director2(DgsDataFetchingEnvironment)}
     * 中通过localContext获取preLoad的数据集填充对应投影字段。
     * 优点：该方式可达到批量获取内嵌关联字段的效果；
     * 缺点：不够灵活，属于定向处理；
     * <pre>
     *     {
     *   listMoviesPreload {
     *     name
     *     director {
     *       id
     *       name
     *     }
     *   }
     * }
     * </pre>
     *
     * @param dfe DataFetchingEnvironment
     * @return DataFetcherResult
     */
    @DgsData(parentType = "Query", field = "listMoviesPreload")
    public DataFetcherResult<List<Movie>> listMovies(DataFetchingEnvironment dfe) {
        List<Movie> movies = movieService.listAll();
        if (dfe.getSelectionSet().contains("director")) {

            Map<Integer, Director> movieIdRefDirector = directorService.loadDirectors();
            return DataFetcherResult.<List<Movie>>newResult()
                    .data(movies)
                    .localContext(movieIdRefDirector)
                    .build();
        } else {
            return DataFetcherResult.<List<Movie>>newResult().data(movies).build();
        }
    }

    /**
     * 通过{@link MovieDataFetcher#listMovies(DataFetchingEnvironment)} preLoad的数据集进行填充
     *
     * @param dfe DgsDataFetchingEnvironment
     * @return Director
     */
    @DgsData(parentType = "Movie3", field = "director")
    public CompletableFuture<Director> director2(DgsDataFetchingEnvironment dfe) {
        Map<Integer, Director> movieIdRefDirector = dfe.getLocalContext();
        Movie movie = dfe.getSource();
        return CompletableFuture.completedFuture(movieIdRefDirector.get(movie.getId()));
    }
}
