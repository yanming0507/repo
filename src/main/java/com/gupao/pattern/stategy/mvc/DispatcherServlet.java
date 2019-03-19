package com.gupao.pattern.stategy.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yan on 2019/3/14.
 */
public class DispatcherServlet extends HttpServlet {
    private static List<Handler> handlers = new ArrayList<Handler>();

    @Override
    public void init() throws ServletException {
        try {
            Class<?> memberController = MemberController.class;
            Handler h = new Handler(memberController.newInstance(),
                    memberController.getMethod("getMemberById",new Class[]{String.class}),
                    "/web/getMemberById.json");
            if (!handlers.contains(h)) {
                handlers.add(h);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        doDispatch(req, res);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse res) {
        //1、获取用户请求的url
        String uri = req.getRequestURI();
        Handler handler = null;
        for (Handler h : handlers) {
            if (h.getUrl().equals(uri)) {
                handler = h;
                break;

            }
        }
        Method method = handler.getMethod();
        Object object=null;
        try {
            object=method.invoke(handler.getController(), req.getParameter("id"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
