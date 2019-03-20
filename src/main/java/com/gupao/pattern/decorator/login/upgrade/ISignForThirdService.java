package com.gupao.pattern.decorator.login.upgrade;

import com.gupao.pattern.decorator.login.ISignService;
import com.gupao.pattern.decorator.login.ResultMsg;

/**
 * Created by Yan on 2019/3/19.
 */
public interface  ISignForThirdService extends ISignService {
    ResultMsg loginForQQ(String qq);
    ResultMsg loginForWechat(String openId);
    ResultMsg loginForToken(String token);
    ResultMsg loginForTel(String tel);
}
