package com.gupao.pattern.stategy.promotion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yan on 2019/3/14.
 * 自己设计的优惠活动工厂
 */
public class PromotionStrategyFactory {
    private static final String CASH="cash";
    private static final String GROUP="group";
    private static final String EMPTY="empty";
    private static final String DEFAULT=EMPTY;
    private static Map<String,PromotionStrategy> register=new HashMap<String ,PromotionStrategy>();
    static {
        register.put(CASH,new CashPromotion());
        register.put(GROUP,new GroupBuyPromotion());
        register.put(EMPTY,new EmptyPromotion());
    }
    public PromotionStrategy execute(String strategy){

          return register.get(strategy) == null ? register.get(DEFAULT) : register.get(strategy);
    }

}
