package com.shf.dsg.producer.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import graphql.execution.instrumentation.Instrumentation;
import graphql.execution.instrumentation.tracing.TracingInstrumentation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description :
 *
 * @author songhaifeng
 * @date 2022/5/8 3:11
 */
@Configuration
public class BeanConfig {
    /**
     * todo
     *
     * @return
     */
    @Bean
    @Qualifier("dgsObjectMapper")
    public ObjectMapper dgsObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        return objectMapper;
    }

    /**
     * 在响应体中将包含tracing相关的信息
     *
     * @return {@link Instrumentation}
     */
    @Bean
    @ConditionalOnProperty(prefix = "graphql.tracing", name = "enabled", matchIfMissing = true)
    public Instrumentation tracingInstrumentation() {
        return new TracingInstrumentation();
    }
}
