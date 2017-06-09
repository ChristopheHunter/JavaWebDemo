package com.quicker.javawebdemo.servlet;

import com.quicker.javawebdemo.entity.User;
import com.quicker.javawebdemo.service.CheckUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zy_git on 2017/6/9.
 */
//@WebServlet(name = "CheckUserServlet")
public class CheckUserServlet extends HttpServlet {

    private CheckUserService checkUserService = new CheckUserService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("=========================doPost==========================");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String userName = request.getParameter("uname");
        String password = request.getParameter("upwd");

        RequestDispatcher rd = null;
        String forward = null;

        if (userName == "" || password == "") {
            System.out.println("用户输入的用户名或者密码为空");
            forward = "/login/illegal.jsp";
            rd = request.getRequestDispatcher(forward);
            rd.forward(request, response);
        } else {
            User user = new User();
            user.setName(userName);
            user.setPassword(password);

            if (checkUserService.check(user)) {
                System.out.println("数据库查找成功！");
                forward = "/login/success.jsp";
            } else {
                System.out.println("数据库查找失败。。。");
                forward = "/login/error.jsp";
            }

            rd = request.getRequestDispatcher(forward);
            rd.forward(request, response);
        }
    }
}
