<%--
  Created by IntelliJ IDEA.
  User: zy_git
  Date: 2017/6/8
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆失败</title>
</head>
<body>
登陆失败。<br/>
您提交的信息是：<br/>
用户名：<%= request.getParameter("uname") %><br/>
密码：<%= request.getParameter("upwd") %><br/>
<a href="/login/login.jsp">返回登陆界面</a>
</body>
</html>
