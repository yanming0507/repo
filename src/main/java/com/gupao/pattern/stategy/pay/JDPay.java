package com.gupao.pattern.stategy.pay;

/**
 * Created by Yan on 2019/3/14.
 */
public class JDPay extends Payment {
    @Override
    public String getName() {
        return "京东白条支付";
    }

    @Override
    public double queryBalance(String userId) {
        return 0;
    }
}
