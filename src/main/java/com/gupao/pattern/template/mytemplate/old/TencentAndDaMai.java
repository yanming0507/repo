package com.gupao.pattern.template.mytemplate.old;

/**
 * Created by Yan on 2019/3/19.
 */
public class TencentAndDaMai {
    public void open(){
        openDaMai();
        openTencent();
    }

    private void openTencent() {
        System.out.println("开通腾讯服务");
    }

    private void openDaMai() {
        System.out.println("开通大麦服务");
    }
}
