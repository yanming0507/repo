package com.gupao.pattern.template.course;

/**
 * Created by Yan on 2019/3/18.
 */
public class BigDataCourse extends NetworkCourse {

    private boolean needHomework;

    public BigDataCourse(boolean needHomework) {
        this.needHomework = needHomework;
    }

    @Override
    protected boolean needHomework() {
        return  this.needHomework;
    }

    @Override
    protected void checkHomework() {
        System.out.println("检查大数据课程作业中。。");
    }
}
