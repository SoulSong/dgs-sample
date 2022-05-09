package com.shf.dsg.producer.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
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
     * @return
     */
    @Bean
    @Qualifier("dgsObjectMapper")
    public ObjectMapper dgsObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        return objectMapper;
    }


}
