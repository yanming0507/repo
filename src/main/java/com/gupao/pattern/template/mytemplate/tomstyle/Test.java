package com.gupao.pattern.template.mytemplate.tomstyle;

/**
 * Created by Yan on 2019/3/19.
 */
public class Test {
    public static void main(String[] args) {
        ThirdServiceAndDaMai thirdServiceAndDaMai=new IQiYiAndDaMai();
        thirdServiceAndDaMai.openService();
        System.out.println("============================");
        thirdServiceAndDaMai=new TencentAndDaMai();
        thirdServiceAndDaMai.openService();
    }
}
