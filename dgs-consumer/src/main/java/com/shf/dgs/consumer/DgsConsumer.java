package com.shf.dgs.consumer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.netflix.graphql.dgs.client.CustomGraphQLClient;
import com.netflix.graphql.dgs.client.GraphQLClient;
import com.netflix.graphql.dgs.client.HttpResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * description :
 *
 * @author songhaifeng
 * @date 2022/5/10 23:58
 */
public class DgsConsumer {
    public static final CustomGraphQLClient client = buildCustomGraphQLClient();
    public static final ObjectMapper objectMapper = new ObjectMapper()
            .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    private static CustomGraphQLClient buildCustomGraphQLClient() {
        RestTemplate restTemplate = new RestTemplate();
        return GraphQLClient.createCustom("http://localhost:8080/graphql", (query, headers, body) -> {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.put("x-request-id", Collections.singletonList("abc-def"));
            headers.forEach(httpHeaders::addAll);
            ResponseEntity<String> exchange = restTemplate.exchange(query, HttpMethod.POST, new HttpEntity<>(body, httpHeaders), String.class);
            return new HttpResponse(exchange.getStatusCodeValue(), exchange.getBody());
        });
    }
}
