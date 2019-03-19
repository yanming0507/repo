package com.gupao.pattern.template.mytemplate;

/**
 * Created by Yan on 2019/3/19.
 */
public class Tencent implements ThirdParty {
    @Override
    public void openThird(ThirdParty thirdParty) {
        System.out.println("现在开通腾讯直播。。。。");
    }
}
