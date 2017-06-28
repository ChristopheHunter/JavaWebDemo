package com.quicker.javawebdemo.day09_jdbc_dbutils;

import com.quicker.javawebdemo.day08_mysql_jdbc.JDBCUtils_v2;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by zy_git on 2017/6/28.
 */
public class MyTest {

    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        MyDataSource myDataSource = null;
        try {
            myDataSource = new MyDataSource();
            conn = myDataSource.getConnection();
            String sql = "insert into tbl_user values(null,?,?,?);";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "小赵");
            pstmt.setString(2, "987008");
            pstmt.setString(3, "infooooo");
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("数据插入成功！");
            else System.out.println("数据插入失败。");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_v2.release(null,pstmt,conn);
        }

    }

}
