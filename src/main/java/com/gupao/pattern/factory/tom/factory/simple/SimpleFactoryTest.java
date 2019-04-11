package com.gupao.pattern.factory.tom.factory.simple;


import com.gupao.pattern.factory.tom.factory.vo.ICourse;
import com.gupao.pattern.factory.tom.factory.vo.PythonCourse;

/**
 * Created by Yan on 2019/3/7.
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        CourseFactory factory=new CourseFactory();
//        ICourse course=com.gupao.pattern.factory.create("cn.qcom.hiveview.mediaapi.module.test.gupao.pattern.com.gupao.pattern.factory.abstractfactory.tom.com.gupao.pattern.factory.vo.JavaCourse");
//        ICourse course=com.gupao.pattern.factory.create(JavaCourse.class);
        ICourse course=factory.create(PythonCourse.class);
        course.record();
//        course=com.gupao.pattern.factory.create("fafd");
//        course.record();

    }
}
