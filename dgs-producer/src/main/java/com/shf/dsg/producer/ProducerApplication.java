package com.shf.dsg.producer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * description :
 *
 * @author songhaifeng
 * @date 2022/5/3 22:25
 */
@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ProducerApplication.class).build().run(args);
    }

}
