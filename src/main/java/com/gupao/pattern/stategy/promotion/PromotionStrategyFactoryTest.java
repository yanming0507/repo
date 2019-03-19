package com.gupao.pattern.stategy.promotion;

/**
 * Created by Yan on 2019/3/14.
 */
public class PromotionStrategyFactoryTest {
    public static void main(String[] args) {
        new PromotionActivity(new PromotionStrategyFactory().execute("cash")).execute();
        new PromotionActivity(PromotionStrategyFactoryTom.createPromotionStrategy("group")).execute();
    }
}
