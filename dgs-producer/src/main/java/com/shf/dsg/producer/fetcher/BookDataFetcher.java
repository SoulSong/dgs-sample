package com.shf.dsg.producer.fetcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.context.DgsContext;
import com.netflix.graphql.dgs.internal.DgsRequestData;
import com.shf.dsg.producer.context.MyContext;
import com.shf.dsg.producer.entity.Actor;
import com.shf.dsg.producer.entity.Book;
import com.shf.dsg.producer.loader.BooksMappedDataLoader;
import com.shf.dsg.producer.service.BookService;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.dataloader.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * description :
 * 多个query按需组合调用
 * <pre>{
 *   list(titleFilter: "a") {
 *     title
 *   }
 *   getById(id: 1) {
 *     title
 *     releaseYear
 *     actors {
 *       name
 *     }
 *   }
 * }</pre>
 *
 * @author songhaifeng
 * @date 2022/5/3 22:22
 */
@DgsComponent
@Slf4j
public class BookDataFetcher {

    @Autowired
    private BookService bookService;

    /**
     * <pre>@DgsQuery same as @DgsData(parentType = "Query", field = "shows")</pre>
     * If the field parameter is not set, the method name will be used as the field name
     *
     * <pre>
     *     {
     *   list(titleFilter: "o") {
     *     title
     *     releaseYear
     *     actors {
     *       name
     *       age
     *     }
     *   }
     * }
     * </pre>
     *
     * @param titleFilter titleFilter
     * @return List of show
     */
    @DgsQuery
    public List<Book> list(@InputArgument String titleFilter) {
        return bookService.list(titleFilter);
    }

    /**
     * <pre>{
     *   getById(id: 1) {
     *     title
     *     releaseYear
     *     actors{name}
     *   }
     * }</pre>
     *
     * @param id id
     * @return Book
     */
    @DgsQuery
    public Book getById(@InputArgument int id) {
        return bookService.get(id);
    }

    /**
     * 入参为{@link Book}对象
     * <pre>
     *     {
     *   actors(book: {title: "Ozark"}) {
     *     name
     *   }
     * }
     * </pre>
     *
     * @param book book
     * @return list of Actors
     */
    @DgsQuery
    public List<Actor> actors(@InputArgument Book book) {
        if ("Ozark".equalsIgnoreCase(book.getTitle())) {
            return Arrays.asList(new Actor("bar2", 1), new Actor("bar2", 1));
        }
        return Collections.singletonList(new Actor("foo2", 1));
    }

    /**
     * 入参为Show集合对象
     * <pre>
     *     {
     *   collect(books: [{title: "aaa"}, {title: "bbb"}]) {
     *     title
     *     releaseYear
     *   }
     * }
     * </pre>
     *
     * @param books list of {@link Book}
     * @return list of {@link Book}
     */
    @DgsQuery
    public List<Book> collect(@InputArgument(collectionType = Book.class) List<Book> books) {
        return books;
    }

    /**
     * 入参可以为Option修饰
     * <pre>{
     *   book(book: {title: "a"}) {
     *     title
     *     actors {
     *       name
     *     }
     *   }
     * }</pre>
     * or
     * <pre>{
     *   book {
     *     title
     *   }
     * }</pre>
     *
     * @param book book
     * @return {@link Book}
     */
    @DgsQuery
    public Book book(@InputArgument(collectionType = Book.class) Optional<Book> book) {
        return book.orElse(null);
    }

    /**
     * <pre>
     *     {hello}
     * </pre>
     * <pre>
     *     {"x-request-id":"sdfaf-afdaf-adfd"}
     * </pre>
     * <pre>
     *     curl -X POST \
     *   http://127.0.0.1:8080/graphql \
     *   -H 'Content-Type: application/json' \
     *   -H 'x-request-id: sdfaf-afdaf-adfd' \
     *   -d '{
     * 	"query":"{  hello }"
     * }'
     * </pre>
     *
     * @param host      host
     * @param requestId requestId
     * @return string
     */
    @DgsQuery
    public String hello(@RequestHeader String host, @RequestHeader(value = "x-request-id", required = false) String requestId) {
        return String.format("host is %s, requestId is %s", host, StringUtils.hasText(requestId) ? requestId : "Unknown");
    }

    /**
     * <pre>{
     *   withContext
     * }</pre>
     *
     * @param dfe DataFetchingEnvironment
     * @return String
     */
    @DgsQuery
    public String withContext(DataFetchingEnvironment dfe) {
        DgsRequestData requestData = DgsContext.getRequestData(dfe);
        MyContext customContext = DgsContext.getCustomContext(dfe);
        return customContext.getCustomState();
    }

    /**
     * 输入参数通过{@link DataFetchingEnvironment#getArgument(String)}方式接收普通类型参数
     * <pre>
     *  mutation {
     *   addBook(title: "a", releaseYear: 12) {
     *     title
     *     releaseYear
     *   }
     * }</pre>
     *
     * @param dataFetchingEnvironment dataFetchingEnvironment
     * @return {@link Book}
     */
    @DgsData(parentType = "Mutation", field = "addBook")
    public Book addBook(DataFetchingEnvironment dataFetchingEnvironment) {
        String title = dataFetchingEnvironment.getArgument("title");
        int releaseYear = dataFetchingEnvironment.getArgument("releaseYear");
        return new Book(title, releaseYear, null);
    }

    /**
     * 输入参数通过{@link DataFetchingEnvironment#getArgument(String)}方式接收对象，
     * 其只能被转换为map对象，需要进行后置处理为自定义对象类型
     * <pre>
     *  mutation {
     *   addBook2(input: {title: "abc", releaseYear: 122}) {
     *     title
     *     releaseYear
     *   }
     * }
     * </pre>
     *
     * @param dataFetchingEnvironment dataFetchingEnvironment
     * @return {@link Book}
     */
    @DgsData(parentType = "Mutation", field = "addBook2")
    public Book addBook2(DataFetchingEnvironment dataFetchingEnvironment) {
        Map<String, Object> input = dataFetchingEnvironment.getArgument("input");
        return new ObjectMapper().convertValue(input, Book.class);
    }

    /**
     * 输入参数为{@link Book}对象
     * <pre>mutation {
     *   addBook3(input: {title: "abc", releaseYear: 122}) {
     *     title
     *     releaseYear
     *   }
     * }</pre>
     *
     * @param book {@link Book}
     * @return {@link Book}
     */
    @DgsData(parentType = "Mutation", field = "addBook3")
    public Book addBook3(@InputArgument("input") Book book) {
        //No need for custom parsing anymore!
        return book;
    }

    /**
     * 通过{@link BooksMappedDataLoader}可将如下的请求体进行batch处理，
     * DataLoader将收集所有的id交给{@link BooksMappedDataLoader#load}方法，
     * 然后通过{@link BookService#loadByIds(Set)}至终端批量获取数据。
     * 从而区别于{@link BookDataFetcher#getById(int)}方法，getById需要与数据库进行多次查询操作，而当前loadBook仅需要一次操作。
     * <pre>
     *     {
     *   book1: loadBook(id: 1) {
     *     title
     *   }
     *   book2: loadBook(id: 2) {
     *     title
     *   }
     *   book3: loadBook(id: 3) {
     *     title
     *   }
     * }
     * </pre>
     *
     * @param id
     * @param dfe
     * @return
     */
    @DgsQuery
    public CompletableFuture<Book> loadBook(@InputArgument int id, DgsDataFetchingEnvironment dfe) {
        DataLoader<Integer, Book> dataLoader = dfe.getDataLoader(BooksMappedDataLoader.class);
        return dataLoader.load(id);
    }
}
