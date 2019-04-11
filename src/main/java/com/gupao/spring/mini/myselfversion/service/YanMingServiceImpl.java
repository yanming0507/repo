package com.gupao.spring.mini.myselfversion.service;

import com.gupao.spring.mini.myselfversion.annotation.YanMingService;

/**
 * Created by Yan on 2019/4/11.
 */
@YanMingService
public class YanMingServiceImpl implements YanMingIService {
    @Override
    public String getName(String name) {
        return "hello "+name;
    }
}
