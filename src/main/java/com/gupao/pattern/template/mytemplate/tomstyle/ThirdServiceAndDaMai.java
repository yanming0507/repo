package com.gupao.pattern.template.mytemplate.tomstyle;

/**
 * Created by Yan on 2019/3/19.
 */
public abstract  class ThirdServiceAndDaMai {
    public void openService(){
        openDaMai();
        openThird();
    }

    private void openDaMai() {
        System.out.println("开通大麦服务。。。。");
    }

   protected abstract void  openThird() ;
}
