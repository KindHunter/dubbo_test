package com.dahuamiao.consumer.controller;

import com.dahuamiao.api.DubboApi;
import com.dahuamiao.consumer.mq.producer.MessageProducer;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @program: dubbo_test
 * @description:
 * @author: wangJun
 * @create: 2020-04-13 09:49
 **/
@RestController
@RequestMapping("ct")
public class DubboController {

    Logger log = LoggerFactory.getLogger(DubboController.class);

    @Reference(timeout = 1000 * 100)
    DubboApi dubboApi;

    @Autowired
    MessageProducer messageProducer;



    @GetMapping("getMessage")
    public String getMessage(){
        Date before = new Date();
        dubboApi.getMessage();
        Date after = new Date();
        log.info("getMessage!");
        return "time consumption:   " + (after.getTime() - before.getTime());
    }


    @GetMapping("sendMessage")
    public String sendMessage(String msg){
        messageProducer.sendAsyncMsg("testTopicOne", "group", msg);
        return "ok";
    }
}
