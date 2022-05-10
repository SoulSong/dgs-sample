package com.shf.dsg.producer.loader;

import com.netflix.graphql.dgs.DgsDataLoader;
import com.shf.common.entity.Book;
import com.shf.dsg.producer.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.MappedBatchLoader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * description :
 * {@link DgsDataLoader}提供了一些参数设置，其默认开启cache，且默认情况下不限制batchSize。
 * 但在一些数据库查询场景下，in是有一定的约束限制的，故此处如下假设maxBatchSize设置为2，
 * 则会根据maxBatchSize的大小分成多个splitBatch进行数据获取。
 *
 * @author songhaifeng
 * @date 2022/5/8 19:38
 */
@DgsDataLoader(name = "bookBatchLoader", maxBatchSize = 2)
@Slf4j
public class BooksMappedDataLoader implements MappedBatchLoader<Integer, Book> {

    @Autowired
    BookService bookService;

    @Override
    public CompletionStage<Map<Integer, Book>> load(Set<Integer> ids) {
        log.info("ids : {}", ids);
        return CompletableFuture.supplyAsync(() -> bookService.loadByIds(ids));
    }
}