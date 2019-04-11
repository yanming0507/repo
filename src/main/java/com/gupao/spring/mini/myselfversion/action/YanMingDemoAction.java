package com.gupao.spring.mini.myselfversion.action;

import com.gupao.spring.mini.myselfversion.annotation.YanMingAutowired;
import com.gupao.spring.mini.myselfversion.annotation.YanMingController;
import com.gupao.spring.mini.myselfversion.annotation.YanMingParam;
import com.gupao.spring.mini.myselfversion.annotation.YanMingRequestMapping;
import com.gupao.spring.mini.myselfversion.service.YanMingIService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Yan on 2019/4/11.
 */
@YanMingController
@YanMingRequestMapping("/yanming")
public class YanMingDemoAction {
    @YanMingAutowired
    private YanMingIService yanMingIService;
    @YanMingRequestMapping("/query")
    public void query(HttpServletRequest request , HttpServletResponse response,@YanMingParam String name)
    {
        String result=yanMingIService.getName(name);
        try {
            response.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
