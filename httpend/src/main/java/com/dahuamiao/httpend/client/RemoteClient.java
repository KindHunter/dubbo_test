package com.dahuamiao.httpend.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "bbWxClient", url = "127.0.0.1:8080")
public interface RemoteClient {


    @GetMapping("ct/getMessage")
    String getMessage();
}
