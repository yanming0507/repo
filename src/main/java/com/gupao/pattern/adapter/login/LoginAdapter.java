package com.gupao.pattern.adapter.login;

/**
 * Created by Yan on 2019/3/18.
 */
public interface LoginAdapter {
    boolean support(Object adapter);
    ResultMsg login(String id,Object adapter);
}
