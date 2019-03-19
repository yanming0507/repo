package com.gupao.pattern.stategy.pay;

/**
 * Created by Yan on 2019/3/14.
 */
public class WeChatPay
extends Payment{
    @Override
    public String getName() {

        return "微信支付";
    }

    @Override
    public double queryBalance(String userId) {
        return 80;
    }
}
