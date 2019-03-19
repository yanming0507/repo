package com.gupao.pattern.stategy.promotion;

/**
 * Created by Yan on 2019/3/14.
 */
public class PromotionActivity {
    private PromotionStrategy strategy;
    public PromotionActivity(PromotionStrategy promotionStrategy){
        this.strategy=promotionStrategy;
    }
    public void execute(){
        strategy.doPromotion();
    }
}
