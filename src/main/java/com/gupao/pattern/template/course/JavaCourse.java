package com.gupao.pattern.template.course;

/**
 * Created by Yan on 2019/3/18.
 */
public class JavaCourse extends NetworkCourse {
    @Override
    protected void checkHomework() {
        System.out.println("检查java课程作业中。。。。");
    }
}
