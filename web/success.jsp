<%--
  Created by IntelliJ IDEA.
  User: zy_git
  Date: 2017/6/8
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆成功提示界面</title>
</head>
<style type="text/css">
    body {
        color: #000;
        font-size: 25px;
        margin: 30px auto;
    }

    #message {
        text-align: center;
    }
</style>
<body>
<div id="message">
    登陆成功！<br/>
    您提交的信息是：<br/>
    用户名：<%= request.getParameter("uname") %><br/>
    密码：<%= request.getParameter("upwd") %><br/>
    <a href="/login.jsp">返回登陆界面</a>
</div>
</body>
</html>
