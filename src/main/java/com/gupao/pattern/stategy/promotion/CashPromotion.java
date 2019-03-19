package com.gupao.pattern.stategy.promotion;

/**
 * Created by Yan on 2019/3/14.
 */
public class CashPromotion implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("每满100减10.。。。。");
    }
}
