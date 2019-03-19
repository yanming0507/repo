package com.gupao.pattern.stategy.pay;

/**
 * Created by Yan on 2019/3/14.
 */
public class PayTest {
    public static void main(String[] args) {
        Order order=new Order("1","1111",200);
        PayState payState=order.pay(PayStrategy.AILI_PAY);
        System.out.println(payState);
        payState=order.pay(PayStrategy.JD_PAY);
        System.out.println(payState);
    }
}
