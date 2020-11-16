package com.dahuamiao.provider.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @program: dubbo_test
 * @description:
 * @author: wangJun
 * @create: 2020-10-30 16:25
 **/
@Document
public class User {

    @Id
    @Field("_id")
    private String _id;

    private String name;

    private String password;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
