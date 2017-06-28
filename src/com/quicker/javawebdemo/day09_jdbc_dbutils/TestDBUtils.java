package com.quicker.javawebdemo.day09_jdbc_dbutils;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by zy_git on 2017/6/28.
 */
public class TestDBUtils {

    @Test
    public void addUser() {
        try {
            QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
            String sql = "insert into tbl_user values(null,?,?,?);";
            Object[] params = {"小明", "33333", "ingosss"};
            int rows = queryRunner.update(sql, params);
            if(rows>0) System.out.println("Succeed!");
            else System.out.println("Failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateById(){
        try {
            QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
            String sql = "update tbl_user set info = ? where uid = 10;";
            Object[] params = {"修改成功！"};
            int rows = queryRunner.update(sql, params);
            if(rows>0) System.out.println("Succeed!");
            else System.out.println("Failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteById(){
        try {
            QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
            String sql = "delete from tbl_user where uid = ?";
            Object[] params = {10};
            int rows = queryRunner.update(sql, params);
            if(rows>0) System.out.println("Succeed!");
            else System.out.println("Failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
