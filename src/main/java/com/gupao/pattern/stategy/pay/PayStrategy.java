package com.gupao.pattern.stategy.pay;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yan on 2019/3/14.
 */
public class PayStrategy {
    public static final String AILI_PAY="ALiPay";
    public static final String UNION_PAY="unionPay";
    public static final String WECHAT_PAY="wechatPay";
    public static final String JD_PAY="jdPay";
    public static final String DEFAULT_PAY=AILI_PAY;
    private static Map<String ,Payment>register=new HashMap<String ,Payment>();

    static {
        register.put(AILI_PAY,new AliPay());
        register.put(WECHAT_PAY,new WeChatPay());
        register.put(UNION_PAY,new UnionPay());
        register.put(JD_PAY,new JDPay());
    }
    public  static Payment getPayment(String type){
        if(register.get(type)!=null){
            return register.get(type);
        }else{
            return register.get(DEFAULT_PAY);
        }
    }
}
