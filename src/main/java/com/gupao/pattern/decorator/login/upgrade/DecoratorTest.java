package com.gupao.pattern.decorator.login.upgrade;

import com.gupao.pattern.decorator.login.SignService;

/**
 * Created by Yan on 2019/3/19.
 */
public class DecoratorTest {
    public static void main(String[] args) {
        ISignForThirdService service=new SignForThirdService(new SignService());
        service.loginForQQ("fsdfsd");
    }
}
