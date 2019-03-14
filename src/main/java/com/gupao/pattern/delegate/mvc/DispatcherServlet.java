package com.gupao.pattern.delegate.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Yan on 2019/3/14.
 */
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDispatch(req,resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
        String id =req.getParameter("id");
        String uri =req.getRequestURI();
        if( "getMemberById".equals(uri)){
            new MemberController().getMemberById(id);
        }else if("getOrderById".equals(uri)){
            new OrderController().getOrderById(id);
        }else if("".equals(uri)){
            new SystemController().logout(id);
        }else{
            try {
                resp.getWriter().write("404 访问的地址不存在");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
