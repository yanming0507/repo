package com.gupao.pattern.adapter.mybusiness.old;

/**
 * Created by Yan on 2019/3/19.
 */
public class Test {
    public static void main(String[] args) {
        TencentAndDaMai tencentAndDaMai=new TencentAndDaMai();
        tencentAndDaMai.openDaMai();
        tencentAndDaMai.openTencent();
        IQiYiAndDaMai iQiYiAndDaMai=new IQiYiAndDaMai();
        iQiYiAndDaMai.openDaMai();
        iQiYiAndDaMai.openIQiYi();
    }
}
