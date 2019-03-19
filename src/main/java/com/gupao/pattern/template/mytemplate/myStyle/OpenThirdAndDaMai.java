package com.gupao.pattern.template.mytemplate.myStyle;

/**
 * Created by Yan on 2019/3/19.
 */
public class OpenThirdAndDaMai {
    private ThirdParty third;

    public OpenThirdAndDaMai(ThirdParty third) {
        this.third = third;
    }

    public void open() {
        openDaMai();
        openThird(third);
    }
    private void openThird(ThirdParty third) {
        System.out.println("使用模板方法模式。。。开通第三方服务。。。。此方法用于调用扩展方法。。");
         third.openThird(third);
    }

    private void openDaMai() {
        System.out.println("开通大麦服务");
    }


}
