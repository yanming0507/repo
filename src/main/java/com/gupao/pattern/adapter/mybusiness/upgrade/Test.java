package com.gupao.pattern.adapter.mybusiness.upgrade;

/**
 * Created by Yan on 2019/3/19.
 */
public class Test {
    public static void main(String[] args) {
        OpenForThirdAdapter adapter=new OpenForThirdAdapter();
        adapter.openIQiYI("macmacmac","snsnsn");
        System.out.println("=====================");
        adapter.openMongo("macmacmac","snsnsn");
        System.out.println("=====================");
        adapter.openTencent("macmacmac","snsnsn");
        System.out.println("=====================");
        adapter.openYouKu("macmacmac","snsnsn");
    }
}
