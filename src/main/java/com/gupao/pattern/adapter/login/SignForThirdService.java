package com.gupao.pattern.adapter.login;

/**
 * Created by Yan on 2019/3/18.
 */
public class SignForThirdService extends SignService {
    public ResultMsg loginForQQ(String openId){
        return register(openId,null);
    }
    public ResultMsg loginForWechat(String openId){
        return null;
    }
    public ResultMsg loginForToken(String openId){
        return null;
    }
    public ResultMsg loginForTelephone(String phone,String code){
        return null;
    }
    public ResultMsg loginForRegist(String userName,String password){
        super.register(userName,password);
        return super.login(userName,password);
    }
}
