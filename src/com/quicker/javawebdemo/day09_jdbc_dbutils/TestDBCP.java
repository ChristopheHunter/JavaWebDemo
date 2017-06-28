package com.quicker.javawebdemo.day09_jdbc_dbutils;

import com.quicker.javawebdemo.day08_mysql_jdbc.JDBCUtils_v2;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by zy_git on 2017/6/28.
 */
public class TestDBCP {

    @Test
    public void test2(){
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBCPUtils.getConnection();
            String sql = "update tbl_user set upassword = ? where uname = ?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"2223333333");
            pstmt.setString(2,"小赵");
            int rows=pstmt.executeUpdate();
            if(rows>0){
                System.out.println("更改成功");
            }else {
                System.out.println("更改失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_v2.release(null,pstmt,conn);
        }
    }

}
