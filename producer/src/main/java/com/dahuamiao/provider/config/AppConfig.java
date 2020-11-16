package com.dahuamiao.provider.config;

import com.dahuamiao.provider.mongoTracing.TraceMongoCommandListener;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: blackbird
 * @description:
 * @author: wangJun
 * @create: 2020-10-28 19:55
 **/
@Configuration
public class AppConfig {


    @Bean
    public MongoClientOptions mongoClient() {
        return MongoClientOptions.builder().addCommandListener(new TraceMongoCommandListener()).build();
    }


}
