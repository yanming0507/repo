package com.gupao.pattern.stategy.promotion;

/**
 * Created by Yan on 2019/3/14.
 */
public class GroupBuyPromotion implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("团购者全部享受团购价格。。。。");
    }
}
