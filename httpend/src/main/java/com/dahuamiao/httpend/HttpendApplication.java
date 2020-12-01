package com.dahuamiao.httpend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: dubbo_test
 * @description:
 * @author: wangJun
 * @create: 2020-12-01 15:19
 **/
@EnableFeignClients
@SpringBootApplication
public class HttpendApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpendApplication.class);
    }
}
