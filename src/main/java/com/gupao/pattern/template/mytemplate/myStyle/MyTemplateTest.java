package com.gupao.pattern.template.mytemplate.myStyle;

/**
 * Created by Yan on 2019/3/19.
 */
public class MyTemplateTest {
    public static void main(String[] args) {
        OpenThirdAndDaMai template=new OpenThirdAndDaMai(new Tencent());
        template.open();
        System.out.println("====================");
        template=new OpenThirdAndDaMai(new IQiYi());
        template.open();
    }
}
