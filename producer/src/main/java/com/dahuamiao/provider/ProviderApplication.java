package com.dahuamiao.provider;

import org.apache.commons.collections4.MapUtils;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.rocketmq.client.hook.ConsumeMessageContext;
import org.apache.rocketmq.client.hook.ConsumeMessageHook;
import org.apache.rocketmq.spring.support.DefaultRocketMQListenerContainer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

/**
 * @program: dubbo_test
 * @description:
 * @author: wangJun
 * @create: 2020-03-31 15:54
 **/
@EnableDubbo
@SpringBootApplication
@MapperScan("com.dahuamiao.provider.mapper")
public class ProviderApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProviderApplication.class, args);

    }
}
