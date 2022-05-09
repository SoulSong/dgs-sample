package com.shf.dsg.producer.loader;

import com.netflix.graphql.dgs.DgsDataLoader;
import com.shf.dsg.producer.entity.Director;
import com.shf.dsg.producer.service.DirectorService;
import org.dataloader.BatchLoader;
import org.dataloader.Try;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

/**
 * https://netflix.github.io/dgs/data-loaders/#implementing-a-data-loader-with-try
 * 官方文档此处有误，此处会批量收集所有的ids，但最终仅能每个id独立load处理。
 * 更多可以参考https://github.com/graphql-java/java-dataloader#error-object-is-not-a-thing-in-a-type-safe-java-world
 *
 * @author songhaifeng
 * @date 2022/5/8 17:44
 */
@DgsDataLoader(name = "directorsWithTry")
public class DirectorsDataLoaderWithTry implements BatchLoader<Integer, Try<Director>> {

    @Autowired
    DirectorService directorService;

    @Override
    public CompletionStage<List<Try<Director>>> load(List<Integer> ids) {
        return CompletableFuture.supplyAsync(() ->
                ids.stream().map(id -> Try.tryCall(() -> directorService.loadDirector(id))).collect(Collectors.toList())
        );
    }
}
