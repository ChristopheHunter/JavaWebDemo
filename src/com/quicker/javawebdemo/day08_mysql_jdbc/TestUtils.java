package com.quicker.javawebdemo.day08_mysql_jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zy_git on 2017/6/27.
 */
public class TestUtils {

    @Test
    public void udate(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils_v3.getConnection();
            String sql = "update tbl_user set upassword = ? where uid = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"new password");
            pstmt.setInt(2,2);
            int rows= pstmt.executeUpdate();
            if(rows>0) System.out.println("删除成功！");
            else System.out.println("删除失败。");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils_v3.release(rs,pstmt,conn);
        }
    }

    @Test
    public void delete(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils_v3.getConnection();
            String sql = "delete from tbl_user where uid = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,3);
            int rows= pstmt.executeUpdate();
            if(rows>0) System.out.println("删除成功！");
            else System.out.println("删除失败。");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils_v3.release(rs,pstmt,conn);
        }
    }

    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils_v2.getConnection();
            String sql = "insert into tbl_user values(null,?,?,'info');";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"老李");
            pstmt.setString(2,"990");
            int rows= pstmt.executeUpdate();
            if(rows>0) System.out.println("插入成功！");
            else System.out.println("插入失败。");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils_v2.release(rs,pstmt,conn);
        }
    }

    @Test
    public void checkUser() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils_v1.getConnection();
            String sql = "select * from tbl_user where uid = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 2);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("uid=" + rs.getString(1) + ",uname=" + rs.getString("uname"));
            } else {
                System.out.println("登陆失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_v1.release(rs, pstmt, conn);
        }
    }

}
