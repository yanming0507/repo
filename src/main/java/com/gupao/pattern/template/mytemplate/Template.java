package com.gupao.pattern.template.mytemplate;

/**
 * Created by Yan on 2019/3/19.
 */
public class Template {
    private Course course;

    public Template(Course course) {
        this.course = course;
    }

    public void createCourse() {
        //    下发预习资料
        this.postPreResource();
        //    制作ppt
        this.createPPT();
        //    在线直播........................待扩展方法
        this.liveVideo(course);
        //    提交课件笔记
        this.postNote();
        //    提交源码
        this.postSource();
    }

    protected void postSource() {
        System.out.println("提交源码。。。");
    }


    protected void postNote() {
        System.out.println("提交课堂笔记。。");
    }


    protected void liveVideo(Course course) {
        System.out.println("在线直播。。");
        course.liveVideo(course);
    }


    protected void createPPT() {
        System.out.println("创建ppt文件。。");
    }


    protected void postPreResource() {
        System.out.println("上传预习资料。。。");
    }


}
