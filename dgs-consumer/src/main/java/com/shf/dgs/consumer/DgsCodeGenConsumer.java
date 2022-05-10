package com.shf.dgs.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.jsonpath.TypeRef;
import com.netflix.graphql.dgs.client.GraphQLResponse;
import com.netflix.graphql.dgs.client.codegen.EntitiesGraphQLQuery;
import com.netflix.graphql.dgs.client.codegen.GraphQLQueryRequest;
import com.shf.common.entity.Book;
import com.shf.dgs.generated.client.AddBook3GraphQLQuery;
import com.shf.dgs.generated.client.AddBook3ProjectionRoot;
import com.shf.dgs.generated.client.CollectGraphQLQuery;
import com.shf.dgs.generated.client.CollectProjectionRoot;
import com.shf.dgs.generated.client.EntitiesProjectionRoot;
import com.shf.dgs.generated.client.GetByIdGraphQLQuery;
import com.shf.dgs.generated.client.GetByIdProjectionRoot;
import com.shf.dgs.generated.client.HelloGraphQLQuery;
import com.shf.dgs.generated.client.ListGraphQLQuery;
import com.shf.dgs.generated.client.ListProjectionRoot;
import com.shf.dgs.generated.client.PostRepresentation;
import com.shf.dgs.generated.types.BookFilter;
import com.shf.dgs.generated.types.BookInput;
import com.shf.dgs.generated.types.Post;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * description :
 * 使用dgs提供的CodeGen能力，通过schema生产相关的客户端代码，并进行后续的query操作。
 *
 * 参考：https://netflix.github.io/dgs/advanced/java-client/#type-safe-query-api
 *
 * @author songhaifeng
 * @date 2022/5/10 23:55
 */
@Slf4j
public class DgsCodeGenConsumer extends DgsConsumer {

    public static void main(String[] args) throws JsonProcessingException {
        hello();
        list();
        getById();
        collect();
        addBook();
        federationPost();
    }

    private static void hello() {
        HelloGraphQLQuery helloGraphQLQuery = HelloGraphQLQuery.newRequest().build();
        GraphQLQueryRequest graphQLQueryRequest = new GraphQLQueryRequest(helloGraphQLQuery);
        GraphQLResponse graphQLResponse = client.executeQuery(graphQLQueryRequest.serialize());
        String result = graphQLResponse.extractValue(helloGraphQLQuery.getOperationName());
        log.info(result);
    }

    private static void list() throws JsonProcessingException {
        ListGraphQLQuery listGraphQLQuery = ListGraphQLQuery.newRequest().titleFilter("o").build();
        GraphQLQueryRequest graphQLQueryRequest = new GraphQLQueryRequest(listGraphQLQuery, new ListProjectionRoot().title().releaseYear());
        GraphQLResponse graphQLResponse = client.executeQuery(graphQLQueryRequest.serialize());
        ArrayList<Book> result = graphQLResponse.extractValueAsObject(listGraphQLQuery.getOperationName(), new TypeRef<ArrayList<Book>>() {
        });
        log.info("{}", objectMapper.writeValueAsString(result));
    }

    private static void getById() throws JsonProcessingException {
        GetByIdGraphQLQuery getByIdGraphQLQuery = GetByIdGraphQLQuery.newRequest().id(2).build();
        GraphQLResponse graphQLResponse = client.executeQuery(new GraphQLQueryRequest(getByIdGraphQLQuery, new GetByIdProjectionRoot().title()).serialize());
        Book result = graphQLResponse.extractValueAsObject(getByIdGraphQLQuery.getOperationName(), Book.class);
        log.info("{}", objectMapper.writeValueAsString(result));
    }

    private static void collect() throws JsonProcessingException {
        CollectGraphQLQuery collectGraphQLQuery = CollectGraphQLQuery.newRequest()
                .books(Arrays.asList(BookFilter.newBuilder().title("a").build(), BookFilter.newBuilder().title("b").build())).build();
        GraphQLResponse graphQLResponse = client.executeQuery(new GraphQLQueryRequest(collectGraphQLQuery, new CollectProjectionRoot().title().releaseYear()).serialize());
        ArrayList<Book> result = graphQLResponse.extractValueAsObject(collectGraphQLQuery.getOperationName(), new TypeRef<ArrayList<Book>>() {
        });
        log.info("{}", objectMapper.writeValueAsString(result));
    }

    private static void addBook() throws JsonProcessingException {
        AddBook3GraphQLQuery addBook3GraphQLQuery = AddBook3GraphQLQuery.newRequest().input(BookInput.newBuilder().title("foo").releaseYear(2018).build()).build();
        GraphQLResponse graphQLResponse = client.executeQuery(new GraphQLQueryRequest(addBook3GraphQLQuery, new AddBook3ProjectionRoot().title().releaseYear()).serialize());
        Book result = graphQLResponse.extractValueAsObject(addBook3GraphQLQuery.getOperationName(), Book.class);
        log.info("{}", objectMapper.writeValueAsString(result));
    }

    /**
     * federation客戶端验证，其采用的是Variable方式发送请求
     */
    public static void federationPost() throws JsonProcessingException {
        EntitiesGraphQLQuery entitiesQuery = new EntitiesGraphQLQuery.Builder()
                .addRepresentationAsVariable(
                        // 当服务端的typeName和schema文件中type不一致时需要指定
                        PostRepresentation.newBuilder().__typename("PostAlias").id("2").build()
                )
                .build();
        GraphQLQueryRequest request = new GraphQLQueryRequest(
                entitiesQuery,
                new EntitiesProjectionRoot().onPost().id().name().reviews().starRating()
        );

        Map<String, Object> representations = entitiesQuery.getVariables();
        GraphQLResponse graphQLResponse = client.executeQuery(request.serialize(), representations);
        // 此处不能使用{@link EntitiesGraphQLQuery#getOperationName}，其值为_entities(representations: $representations)
        List<Post> result = graphQLResponse.extractValueAsObject("_entities", new TypeRef<ArrayList<Post>>() {
        });
        log.info("{}", objectMapper.writeValueAsString(result));
    }
}
