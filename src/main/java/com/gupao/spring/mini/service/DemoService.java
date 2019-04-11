package com.gupao.spring.mini.service;

import com.gupao.spring.mini.annotation.GPService;

/**
 * Created by Yan on 2019/4/10.
 */
@GPService
public class DemoService implements IDemoService{
    @Override
    public String get(String name) {
        return "my name is "+name ;
    }
}
