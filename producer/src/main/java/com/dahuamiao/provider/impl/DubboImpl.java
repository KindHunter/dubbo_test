package com.dahuamiao.provider.impl;

import com.dahuamiao.api.DubboApi;
import org.apache.dubbo.config.annotation.Service;

import java.util.Date;

/**
 * @program: dubbo_test
 * @description:
 * @author: wangJun
 * @create: 2020-04-13 09:52
 **/
@Service
public class DubboImpl implements DubboApi {
    @Override
    public Long getMessage() {
        Date date = new Date();
        return date.getTime();
    }
}
