package com.gupao.pattern.template.mytemplate.old;

/**
 * Created by Yan on 2019/3/19.
 */
public class IQiYiAndDaMai {
    public void open(){
        openDaMai();
        openIQiYi();
    }

    private void openIQiYi() {
        System.out.println("开通爱奇艺服务");
    }

    private void openDaMai() {
        System.out.println("开通大麦服务");
    }
}
