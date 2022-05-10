package com.shf.dgs.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.netflix.graphql.dgs.client.GraphQLClient;
import com.netflix.graphql.dgs.client.GraphQLResponse;
import com.shf.common.entity.Book;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * description :
 * 使用{@link GraphQLClient}发送ql请求，并获取解析对应的结果集。
 * 本示例不使用dgsCodegen插件能力，其请求方式相对原始。
 * 参考：https://netflix.github.io/dgs/advanced/java-client/
 *
 * @author songhaifeng
 * @date 2022/5/10 10:17
 */
@Slf4j
public class DgsSimpleConsumer extends DgsConsumer {

    public static void main(String[] args) throws JsonProcessingException {
        hello();
        list();
        getById();
        collect();
        federationPost();
    }

    private static void hello() {
        GraphQLResponse graphQLResponse = client.executeQuery("{hello}");
        String result = graphQLResponse.extractValue("hello");
        log.info(result);
    }

    private static void list() throws JsonProcessingException {
        GraphQLResponse graphQLResponse = client.executeQuery("{list(titleFilter: \"o\") { title,releaseYear}}");
        ArrayList<Book> result = graphQLResponse.extractValue("list");
        log.info("{}", objectMapper.writeValueAsString(result));
    }

    private static void getById() throws JsonProcessingException {
        GraphQLResponse graphQLResponse = client.executeQuery("{getById(id: 2) { title,releaseYear}}");
        Book result = graphQLResponse.extractValueAsObject("getById", Book.class);
        log.info("{}", objectMapper.writeValueAsString(result));
    }

    private static void collect() throws JsonProcessingException {
        GraphQLResponse graphQLResponse = client.executeQuery("{collect(books: [{title:\"a\"},{title:\"b\"}]) {title,releaseYear}}");
        ArrayList<Book> result = graphQLResponse.extractValue("collect");
        log.info("{}", objectMapper.writeValueAsString(result));
    }

    public static void federationPost() throws JsonProcessingException {
        Map<String, Object> variables = new HashMap<>();
        Map<String, Object> representation = new HashMap<>();
        representation.put("__typename", "PostAlias");
        representation.put("id", 2);
        variables.put("representations", Collections.singletonList(representation));

        GraphQLResponse graphQLResponse = client.executeQuery("query($representations: [_Any!]!) {_entities(representations: $representations){ ... on Post { id name reviews   { starRating } } } }", variables);

        ArrayList<Book> result = graphQLResponse.extractValue("_entities");
        log.info("{}", objectMapper.writeValueAsString(result));
    }
}
