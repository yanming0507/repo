package com.gupao.pattern.template.course;

/**
 * Created by Yan on 2019/3/18.
 */
public abstract class NetworkCourse {
    protected final void createCourse() {
        //    下发预习资料
        this.postPreResource();
        //    制作ppt
        this.createPPT();
        //    在线直播
        this.liveVideo();
        //    提交课件笔记
        this.postNote();
        //    提交源码
        this.postSource();
        //    若需要则,布置作业
        if (needHomework()) {
            checkHomework();
        }
    }

    protected boolean needHomework() {
        return false;
    }



    protected void postSource() {
        System.out.println("提交源码。。。");
    }


    protected void postNote() {
        System.out.println("提交课堂笔记。。");
    }


    protected void liveVideo() {
        System.out.println("在线直播。。");
    }


    protected void createPPT() {
        System.out.println("创建ppt文件。。");
    }


    protected void postPreResource() {
        System.out.println("上传预习资料。。。");
    }


    protected abstract void checkHomework();


}
