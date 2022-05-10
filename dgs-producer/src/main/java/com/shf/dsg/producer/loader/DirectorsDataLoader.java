package com.shf.dsg.producer.loader;

import com.netflix.graphql.dgs.DgsDataLoader;
import com.shf.common.entity.Director;
import com.shf.dsg.producer.service.DirectorService;
import org.dataloader.BatchLoader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * N+1问题描述：
 * 当我们需要从MovieService获取N部Movie数据时，同时需要获取每部电影的的Director数据，
 * 而Director数据需要从另外一个DirectorService服务获取或者数据库表独立查询。此时即获取Movie远程访问次数1，
 * 获取Director远程访问次数为N，即每部Movie需要执行一次Director的远程调用，故累计为N+1.
 * <p>
 * 解决方案：
 * 通过实现{@link BatchLoader} 或者 {@link org.dataloader.MappedBatchLoader}接口，
 * 在部分key没有value的场景下，MappedBatchLoader是更好的选择。
 * <p>
 * 前提：
 * DirectorService服务需要提供批量获取Director集合的能力。
 *
 * @author songhaifeng
 * @date 2022/5/8 17:44
 */
@DgsDataLoader(name = "directors", caching = true)
public class DirectorsDataLoader implements BatchLoader<Integer, Director> {

    @Autowired
    DirectorService directorService;

    @Override
    public CompletionStage<List<Director>> load(List<Integer> movieIds) {
        // CompletableFuture允许指定自定义线程池，在线程上下文传递的场景下，通常使用自定义线程池
        return CompletableFuture.supplyAsync(() -> directorService.loadDirectors(movieIds));
    }
}
