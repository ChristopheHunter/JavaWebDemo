<%--
  Created by IntelliJ IDEA.
  User: zy_git
  Date: 2017/6/13
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<style type="text/css">
    body {
        color: #000;
        font-size: 25px;
        margin: 30px auto;
    }
</style>
<script type="text/javascript">
    function check(form) {
        if (document.forms.loginForm.uname.value == "") {
            alert("请输入用户名！")
            document.forms.loginForm.uname.focus()
        }
        if (document.forms.loginForm.upwd.value == "") {
            alert("请输入密码！")
            document.forms.loginForm.upwd.focus()
        }
    }
</script>
<body>
<form action="<%request.getContextPath();%>/CheckUserServlet" method="post" name="loginForm">
    <table border="1" cellspacing="0" cellpadding="5" align="center">
        <tr>
            <td colspan="2" align="center" bgcolor="#E8E8E8">用户登录</td>
        </tr>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="uname"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="upwd"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" name="Submit" onclick="return check(this);"/>
                <input type="reset" name="Reset"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
