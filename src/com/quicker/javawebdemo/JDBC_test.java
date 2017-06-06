package com.quicker.javawebdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by zy_git on 2017/6/6.
 */
public class JDBC_test {

    public static void main(String[] args){
        String sql = "select * from tbl_user";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_jdbc","root","314413");
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()){
                System.out.println(rs.getInt("id")+"");
                System.out.println(rs.getString("name")+"");
                System.out.println(rs.getString("password")+"");
                System.out.println(rs.getString("email")+"");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {

            try {
                rs.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }

            try {
                st.close();
            }catch (Exception e3){
                e3.printStackTrace();
            }

            try {
                conn.close();
            }catch (Exception e4){
                e4.printStackTrace();
            }

        }
    }
}
