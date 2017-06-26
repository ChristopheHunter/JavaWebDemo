package com.quicker.javawebdemo.odd.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by zy_git on 2017/6/7.
 */
public class TransactionTest {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "314413");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private static void insertUserData(Connection conn) throws SQLException {
        String sql = "INSERT INTO tbl_user(id,name,email) values(10,'WangWu','45115@qq.com')";
        Statement st = conn.createStatement();
        int count = st.executeUpdate(sql);
        System.out.println("向用户表中添加了" + count + "条信息");
    }

    private static void insertAddress(Connection conn) throws SQLException {
        String sql = "INSERT INTO tbl_address(id,city,country,user_id) VALUES (2,'GuangZhou','China',10)";
        Statement st = conn.createStatement();
        int cout = st.executeUpdate(sql);
        System.out.println("向地址表中插入" + cout + "条信息");
    }

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            insertUserData(conn);
            insertAddress(conn);

            conn.commit();
        } catch (SQLException e) {
            System.out.println("----------------------捕获到SQL异常-----------------------");
            try {
                conn.rollback();
                System.out.println("----------------------事务回滚-----------------------");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
