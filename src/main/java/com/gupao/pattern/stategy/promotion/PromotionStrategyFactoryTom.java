package com.gupao.pattern.stategy.promotion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yan on 2019/3/14.
 */
public class PromotionStrategyFactoryTom {
    private static Map<String, PromotionStrategy> register = new HashMap<String, PromotionStrategy>();

    static {
        //注册式单例
        register.put(PromotionStrategyKey.CASH, new CashPromotion());
        register.put(PromotionStrategyKey.GROUP, new GroupBuyPromotion());
    }
    private PromotionStrategyFactoryTom(){}

    //分工明确，只用于提供字符串
    private interface PromotionStrategyKey {
        String CASH = "cash";
        String GROUP = "group";
    }

    private static final PromotionStrategy DEFAULT = new EmptyPromotion();

    //策略模式，根据参数不同，生成不同优惠策略，使用策略模式之后，
    // 不用有那么多的if else判断，扩展时只需要增加对应的策略和增加工厂类的对应策略即可。不会影响以前的代码逻辑，后期的测试点不会增多
    public static PromotionStrategy createPromotionStrategy(String type) {


        return register.get(type) != null ? register.get(type) : PromotionStrategyFactoryTom.DEFAULT;
    }

}
