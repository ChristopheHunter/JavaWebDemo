<%--
  Created by IntelliJ IDEA.
  User: zy_git
  Date: 2017/6/8
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <script type="text/javascript">
        function check(form) {
            
        }
    </script>
</head>
<body>
<form action="/CheckUserServlet" method="get">
    userName:<input type="text" name="uname"/> <br/>
    password:<input type="password" name="upwd"/> <br/>
    <input type="submit" value="Login">
    <input type="reset" value="Reset">
</form>
</body>
</html>
