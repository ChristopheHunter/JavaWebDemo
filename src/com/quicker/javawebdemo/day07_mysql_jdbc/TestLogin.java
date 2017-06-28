package com.quicker.javawebdemo.day07_mysql_jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * Created by zy_git on 2017/6/26.
 */
public class TestLogin {

    public static void main(String[] args) {
        try {
            login2("name_1", "123");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public static void login(String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_test", "root", "314413");
        Statement stmt = conn.createStatement();
        String sql = "select * from tbl_user where " + "uname='" + username + "' and upassword='" + password + "'";
        ResultSet rs = stmt.executeQuery(sql);
        //对结果集进行处理
        if (rs.next()) {
            System.out.println("登陆成功！");
            System.out.println(sql);
        } else {
            System.out.println("无对应数据。");
        }

        rs.close();
        stmt.close();
        conn.close();
    }

    public static void login2(String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db_test",
                "root",
                "314413");
        String sql = "select * from tbl_user where uname = ? and upassword = ?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,username);
        pstmt.setString(2,password);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next())
            System.out.println(username+"登陆成功！");
        else
            System.out.println("登陆失败。。。");
        rs.close();
        pstmt.close();
        conn.close();
    }
}
