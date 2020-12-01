package com.dahuamiao.httpend.controller;

import com.dahuamiao.httpend.client.RemoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: dubbo_test
 * @description:
 * @author: wangJun
 * @create: 2020-12-01 15:20
 **/
@RestController
@RequestMapping("tt")
public class TestController {

    @Autowired
    RemoteClient remoteClient;

    @GetMapping("getText")
    public String getText(){
        return remoteClient.getMessage();
    }
}
