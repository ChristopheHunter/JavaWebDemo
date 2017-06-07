package com.quicker.javawebdemo.test;

import java.sql.*;

/**
 * Created by zy_git on 2017/6/6.
 */
public class JDBC_test {

    //获取链接
    private static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc", "root", "314413");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    //插入数据
    public static void insert() {
        Connection conn = getConnection();
        try {
            String sql = "INSERT INTO tbl_user VALUES(2,'ccc','1234456','asd@aa.com');";
//            String sql = "select * from tbl_user";
            Statement st = conn.createStatement();
            int count = st.executeUpdate(sql);
            System.out.println("向数据库执行了" + count + "条语句");

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //更新数据
    private static void update() {
        Connection conn = getConnection();
        String sql = "UPDATE tbl_user SET email = 'zy_git@163.com' WHERE id = 2";
        Statement st = null;
        try {
            st = conn.createStatement();
            int count = st.executeUpdate(sql);
            System.out.println("向数据库执行了" + count + "条语句");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //删除数据
    private static void delete() {
        Connection conn = getConnection();
        String sql = "DELETE FROM tbl_user WHERE id = 2";
        try {
            Statement st = conn.createStatement();
            int count = st.executeUpdate(sql);
            System.out.println("向数据库执行了" + count + "条语句");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

//        insert();
//        update();
//        delete();

        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);          //禁止自动提交
            insertTest(conn);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertTest(Connection conn) throws SQLException{
        String sql = "INSERT INTO tbl_user(id,name) VALUES(1,'dd')";
            Statement st = conn.createStatement();
            int cout = st.executeUpdate(sql);
            System.out.print("插入了"+cout+"条数据");
    }
}
