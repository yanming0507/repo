package com.gupao.pattern.template.mytemplate;

/**
 * Created by Yan on 2019/3/19.
 */
public class JavaCourse implements Course {
    @Override
    public void liveVideo(Course course) {
        System.out.println("现在直播的是java课程");
    }
}
