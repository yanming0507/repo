package com.gupao.pattern.factory.tom.factory.simple;


import com.gupao.pattern.factory.tom.factory.vo.ICourse;

/**
 * Created by Yan on 2019/3/7.
 */
public class CourseFactory {
    /*
    1、
    public  ICourse create(String course) {
        if ("java".equals(course)) {
            return new JavaCourse();
        } else if ("python".equals(course)) {
            new PythonCourse();
        }
        return null;
    }*/
    public ICourse create(String course) {
        if (null != course && !"".equals(course)) {
            try {
                return (ICourse) Class.forName(course).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public ICourse create(Class<? extends ICourse> clazz) {
        if (null != clazz) {

            try {
                return clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }

        }
        return null;
    }
}
