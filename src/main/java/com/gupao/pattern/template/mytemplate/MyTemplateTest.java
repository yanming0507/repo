package com.gupao.pattern.template.mytemplate;

/**
 * Created by Yan on 2019/3/19.
 */
public class MyTemplateTest {
    public static void main(String[] args) {
        Template template=new Template(new JavaCourse());
        template.createCourse();
        System.out.println("====================");
        template=new Template(new BigCourse());
        template.createCourse();
    }
}
