package com.quicker.javawebdemo.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zy_git on 2017/6/8.
 */
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("==================doGet==================");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("==================doPost==================");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html ; charset=utf-8");

        //获取表单提交的内容
        String userName = req.getParameter("uname");
        String password = req.getParameter("upwd");

        System.out.println("用户名 ==》》" + userName);
        System.out.println("密码   ==》》" + password);

        String forward = null;

        if (userName.equals("zy") && password.equals("123")) {


            //请求转发，只能发生在同一应用的jsp
            forward = "/login/success.jsp";                                 //请求的转发地址
            RequestDispatcher rd = req.getRequestDispatcher(forward);       //请求调度器
            rd.forward(req, resp);

            //请求重定向
//            resp.sendRedirect(req.getContextPath() + "/login/success.jsp");
//            resp.sendRedirect("http://www.baidu.com");
        } else {
            forward = "/login/error.jsp";
            RequestDispatcher rd = req.getRequestDispatcher(forward);
            rd.forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
