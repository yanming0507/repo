package com.gupao.spring.mini.action;

import com.gupao.spring.mini.annotation.GPAutowired;
import com.gupao.spring.mini.annotation.GPController;
import com.gupao.spring.mini.annotation.GPRequestMapping;
import com.gupao.spring.mini.annotation.GPRequestParam;
import com.gupao.spring.mini.service.IDemoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Yan on 2019/4/10.
 */
@GPController
@GPRequestMapping("/demo")
public class DemoAction {
    @GPAutowired
    private IDemoService demoService;

    @GPRequestMapping("/query.*")
    public void query(HttpServletRequest request, HttpServletResponse response, @GPRequestParam("name") String name) {
        String result = demoService.get(name);
        try {
            response.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



   /* public static void test(List<Integer> list) {
         Integer a=1;
         Integer b=2;
         Integer c=3;
         Integer d=3;
         Integer e=321;
         Integer f=321;
         Long g=3L;
        System.out.println(c==d);
        System.out.println(f==e);
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));
    }

    public static void main(String[] args) {
        test(null);
    }*/
}
