package com.gupao.pattern.adapter.login;

/**
 * Created by Yan on 2019/3/18.
 */
public class SignService {
    public ResultMsg register(String name, String password) {
        return new ResultMsg("注册成功", 200, new Member());
    }
    public ResultMsg login(String userName,String password){
        return null;
    };
}
