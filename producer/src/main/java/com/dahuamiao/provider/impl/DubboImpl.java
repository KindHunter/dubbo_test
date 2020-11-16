package com.dahuamiao.provider.impl;

import com.dahuamiao.api.DubboApi;
import com.dahuamiao.provider.mapper.AreaMapper;
import com.dahuamiao.provider.model.Area;
import com.dahuamiao.provider.model.User;
import com.dahuamiao.provider.repository.UserRepository;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @program: dubbo_test
 * @description:
 * @author: wangJun
 * @create: 2020-04-13 09:52
 **/
@Service()
public class DubboImpl implements DubboApi {

    Logger log = LoggerFactory.getLogger(DubboImpl.class);


    @Autowired
    AreaMapper areaMapper;


    @Autowired
    UserRepository userRepository;

    @Override
    public Long getMessage() {
        Date date = new Date();
        Area area = areaMapper.selectById(110000);
        Date date1 = new Date();
        System.out.println(date1.getTime() - date.getTime());
        log.info("getMessage!");
        return date.getTime();
    }

    @Override
    public void addUser(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userRepository.insert(user);
    }
}
