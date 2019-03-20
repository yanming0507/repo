package com.gupao.pattern.decorator.login.upgrade;

import com.gupao.pattern.decorator.login.ISignService;
import com.gupao.pattern.decorator.login.ResultMsg;

/**
 * Created by Yan on 2019/3/19.
 */
public class SignForThirdService implements ISignForThirdService {
    private ISignService sign;

    public SignForThirdService(ISignService sign) {
        this.sign = sign;
    }

    @Override
    public ResultMsg register(String userName, String passWord) {
        return sign.register(userName,passWord);
    }

    @Override
    public ResultMsg login(String userName, String password) {
        return sign.login(userName,password);
    }

    @Override
    public ResultMsg loginForQQ(String qq) {
        System.out.println("loginForQQ.............");
        return null;
    }

    @Override
    public ResultMsg loginForWechat(String openId) {
        System.out.println("loginForWechat.............");
        return null;
    }

    @Override
    public ResultMsg loginForToken(String token) {
        System.out.println("loginForToken.............");
        return null;
    }

    @Override
    public ResultMsg loginForTel(String tel) {
        System.out.println("loginForTel.............");
        return null;
    }
}
