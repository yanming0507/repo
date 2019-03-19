package com.gupao.pattern.template.mytemplate;

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
        System.out.println("开通第三方服务");
         third.openThird(third);
    }

    private void openDaMai() {
        System.out.println("开通大麦服务");
    }


}
