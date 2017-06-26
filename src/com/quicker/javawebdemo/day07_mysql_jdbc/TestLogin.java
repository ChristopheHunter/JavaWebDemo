package com.quicker.javawebdemo.day07_mysql_jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * Created by zy_git on 2017/6/26.
 */
public class TestLogin {

    public static void main(String[] args){
        try {
            login("name_1","1234");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public static void login(String username, String password) throws ClassNotFoundException, SQLException {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_test", "root", "314413");
        //创建执行SQL语句的对象
        Statement stmt = conn.createStatement();
        //书写SQL语句
        String sql = "select * from tbl_user where " + "uname='" + username + "' and upassword='" + password + "'";
        //执行SQL语句
        ResultSet rs = stmt.executeQuery(sql);
        //对结果集进行处理
        if (rs.next()){
            System.out.println("登陆成功！");
        }else {
            System.out.println("无对应数据。");
        }
    }
}
