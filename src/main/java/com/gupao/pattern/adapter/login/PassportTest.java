package com.gupao.pattern.adapter.login;

/**
 * Created by Yan on 2019/3/18.
 */
public class PassportTest {
    public static void main(String[] args) {
        IPassportForThird third=new PassportForThirdAdapter();
        third.loginForQQ("fsffdfsfd");
    }
}
