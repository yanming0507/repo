package com.gupao.pattern.stategy.pay;

/**
 * Created by Yan on 2019/3/14.
 */
public class AliPay extends Payment {
    @Override
    public String getName() {
        return "支付宝支付";
    }

    @Override
    public double queryBalance(String userId) {
        return 2000;
    }
}
