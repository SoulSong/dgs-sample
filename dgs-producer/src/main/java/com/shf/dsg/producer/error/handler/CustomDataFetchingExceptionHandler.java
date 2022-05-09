package com.shf.dsg.producer.error.handler;

import com.netflix.graphql.dgs.exceptions.DefaultDataFetcherExceptionHandler;
import com.netflix.graphql.types.errors.TypedGraphQLError;
import graphql.GraphQLError;
import graphql.execution.DataFetcherExceptionHandler;
import graphql.execution.DataFetcherExceptionHandlerParameters;
import graphql.execution.DataFetcherExceptionHandlerResult;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * description :
 * 其仅处理来源于dataFetcher的exception。其可以在response中添加errors模块，
 * 当部分字段被正确获取，部分字段触发exception时，response中将包含data和errors两部分：
 * - data 正常处理字段将在data部分，而触发exception的字段将被赋值null
 * - errors 触发异常的字段将在此处显示，并
 * <p>
 * 实现：
 * 其必须最终代理给{@link DefaultDataFetcherExceptionHandler}实例
 *
 * @author songhaifeng
 * @date 2022/5/9 0:56
 */
@Component
public class CustomDataFetchingExceptionHandler implements DataFetcherExceptionHandler {
    private final DefaultDataFetcherExceptionHandler defaultHandler = new DefaultDataFetcherExceptionHandler();

    @Override
    public DataFetcherExceptionHandlerResult onException(DataFetcherExceptionHandlerParameters handlerParameters) {
        // 自定义异常标准输出处理
        if (handlerParameters.getException() instanceof CustomException) {
            Map<String, Object> debugInfo = new HashMap<>();
            debugInfo.put("somefield", "somevalue");

            // 更多error返回结构参考https://netflix.github.io/dgs/error-handling/#the-graphqlerror-interface
            GraphQLError graphqlError = TypedGraphQLError.INTERNAL.message("This custom thing went wrong!")
                    .debugInfo(debugInfo)
                    .path(handlerParameters.getPath()).build();
            return DataFetcherExceptionHandlerResult.newResult()
                    .error(graphqlError)
                    .build();
        } else {
            return defaultHandler.onException(handlerParameters);
        }
    }
}