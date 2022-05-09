package com.shf.dsg.producer.context;

import com.netflix.graphql.dgs.context.DgsCustomContextBuilder;
import com.netflix.graphql.dgs.context.DgsCustomContextBuilderWithRequest;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * description :
 *
 * @author songhaifeng
 * @date 2022/5/8 2:32
 */
@Component
public class MyContextBuilder implements DgsCustomContextBuilderWithRequest<MyContext> {

    @Override
    public MyContext build(@Nullable Map<String, ?> map, @Nullable HttpHeaders httpHeaders, @Nullable WebRequest webRequest) {
        //e.g. you can now read headers to set up context
        return new MyContext();
    }
}