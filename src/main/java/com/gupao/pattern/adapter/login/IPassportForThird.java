package com.gupao.pattern.adapter.login;

/**
 * Created by Yan on 2019/3/18.
 */
public interface IPassportForThird {
        ResultMsg loginForQQ(String qq);
        ResultMsg loginForWechat(String openId);
        ResultMsg loginForToken(String token);
        ResultMsg loginForSina(String id);
        ResultMsg loginForTel(String tel);
        ResultMsg loginForRegist(String userName,String password);
}
