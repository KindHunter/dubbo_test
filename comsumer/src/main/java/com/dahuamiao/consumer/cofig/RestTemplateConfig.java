//package com.dahuamiao.consumer.cofig;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.ClientHttpRequestFactory;
//import org.springframework.http.client.SimpleClientHttpRequestFactory;
//import org.springframework.web.client.RestTemplate;
//
///**
// * @program: dubbo_test
// * @description:
// * @author: wangJun
// * @create: 2020-06-19 16:57
// **/
//@Configuration
//public class RestTemplateConfig {
//    @Bean
//    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
//        return new RestTemplate(factory);
//    }
//
//    @Bean
//    public ClientHttpRequestFactory clientHttpRequestFactory() {
//        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        factory.setConnectTimeout(5000);
//        factory.setReadTimeout(5000);
//        return factory;
//    }
//}