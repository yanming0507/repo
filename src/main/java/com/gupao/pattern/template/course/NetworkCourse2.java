package com.gupao.pattern.template.course;

/**
 * Created by Yan on 2019/3/18.
 */
public interface   NetworkCourse2 {
    default void  createCourse() {
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

     boolean needHomework();
     void postSource();
     void postNote();
     void liveVideo();
     void createPPT();
     void postPreResource();
      void checkHomework();


}
