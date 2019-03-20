package com.gupao.pattern.decorator.login;

/**
 * Created by Yan on 2019/3/19.
 */
public class SignService implements ISignService {
    @Override
    public ResultMsg register(String userName, String passWord) {
        return new ResultMsg("注册成功",200,new com.gupao.pattern.decorator.login.Member());
    }

    @Override
    public ResultMsg login(String userName, String password) {
        return null;
    }
}
