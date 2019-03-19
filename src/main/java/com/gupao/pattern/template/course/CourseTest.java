package com.gupao.pattern.template.course;

/**
 * Created by Yan on 2019/3/18.
 */
public class CourseTest{
    public static void main(String[] args) {
        NetworkCourse course=new JavaCourse();
        course.createCourse();
        System.out.println("=====================");
        NetworkCourse bigDataCourse=new BigDataCourse(true);
        bigDataCourse.createCourse();
    }
}
