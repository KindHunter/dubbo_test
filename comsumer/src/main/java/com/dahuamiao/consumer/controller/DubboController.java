package com.dahuamiao.consumer.controller;

import com.dahuamiao.api.Constants;
import com.dahuamiao.api.DubboApi;
import com.dahuamiao.consumer.rocketmq.MessageProducer;
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

    @Autowired
    MessageProducer messageProducer;

    @Reference
    DubboApi dubboApi;


    @GetMapping("getMessage")
    public String getMessage(){
        Date before = new Date();
        dubboApi.getMessage();
        Date after = new Date();
        log.info("getMessage!");
        return "time consumption:   " + (after.getTime() - before.getTime());
    }


    @GetMapping("addUser")
    public void addUser(String name, String password){
        dubboApi.addUser(name, password);
    }


    @GetMapping("sendMsg")
    public void sendMsg(){
        messageProducer.sendAsyncMsg(Constants.TOPIC, Constants.TAG, "my message!");
    }

}
