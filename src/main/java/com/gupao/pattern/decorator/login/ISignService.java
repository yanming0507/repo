package com.gupao.pattern.decorator.login;

/**
 * Created by Yan on 2019/3/19.
 */
public interface ISignService {
    ResultMsg register(String userName,String passWord);
    ResultMsg login(String userName,String password);
}
