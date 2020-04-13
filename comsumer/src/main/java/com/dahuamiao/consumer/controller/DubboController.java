package com.dahuamiao.consumer.controller;

import com.dahuamiao.api.DubboApi;
import org.apache.dubbo.config.annotation.Reference;
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

    @Reference
    DubboApi dubboApi;



    @GetMapping("getMessage")
    public String getMessage(){
        Date before = new Date();
        dubboApi.getMessage();
        Date after = new Date();
        return "time consumption:   " + (after.getTime() - before.getTime());
    }
}
