package com.gupao.pattern.stategy.promotion;

/**
 * Created by Yan on 2019/3/14.
 */
public class PromotionTest {
    /*public static void main(String[] args) {//
        PromotionActivity activity=new PromotionActivity(new GroupBuyPromotion());
        PromotionActivity activity1=new PromotionActivity(new CashPromotion());
        activity.execute();
        activity1.execute();
    }*/
    public static void main(String[] args) {//每次增加促销活动，则需要修改代码。。。。不符合开闭原则
        PromotionActivity activity = null;
        String promotionKey = "group222";
        if (promotionKey.equals("group")) {
            activity=new PromotionActivity(new GroupBuyPromotion());
        } else if ("cash".equals(promotionKey)) {
            activity=new PromotionActivity(new CashPromotion());
        } else {
            activity=new PromotionActivity(new EmptyPromotion());
        }
            activity.execute();
    }
}
