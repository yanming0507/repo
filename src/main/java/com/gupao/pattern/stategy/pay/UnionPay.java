package com.gupao.pattern.stategy.pay;

/**
 * Created by Yan on 2019/3/14.
 */
public class UnionPay extends Payment {
    @Override
    public String getName() {
        return "银联支付";
    }

    @Override
    public double queryBalance(String userId) {
        return 90;
    }
}
