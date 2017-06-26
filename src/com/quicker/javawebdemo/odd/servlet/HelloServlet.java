package com.quicker.javawebdemo.odd.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zy_git on 2017/6/8.
 */
public class HelloServlet extends HttpServlet{

    @Override
    public void init() throws ServletException {
//        super.init();
        System.out.println("=======================无参init===========================");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("=======================有参init===========================");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("=======================service===========================");
        PrintWriter pw = resp.getWriter();
        pw.println("Hello Servlet!");           //想客户端服务器输出
        pw.close();
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("=======================有参init===========================");
    }
}
