package com.quicker.javawebdemo.day09_jdbc_dbutils;

import com.quicker.javawebdemo.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by zy_git on 2017/6/28.
 */
public class TestDBUtils2 {

    @Test
    public void selectAllUser() {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from tbl_user;";
        try {
            List<User> users = queryRunner.query(sql, new BeanListHandler<User>(User.class));
            for (User u : users)
                System.out.println("username:" + u.getUname() + ",password" + u.getUpassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectAllUser2() {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from tbl_user;";
        try {
            List<Map<String, Object>> maps = queryRunner.query(sql, new MapListHandler());
            for (Map<String,Object>  maplist: maps)
                System.out.println(maplist.get("uname"));
//                System.out.println(maplist);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectById() {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from tbl_user where uid in(?,?);";
        Object[] params = {1,2};
        try {
            List<User> users = queryRunner.query(sql, new BeanListHandler<User>(User.class),params);
            for (User u : users)
                System.out.println("id:"+u.getUid()+",username:" + u.getUname() + ",password" + u.getUpassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryCount() {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select count(*) from tbl_user;";
        Object[] params = {1,2};
        try {
            Long c = (Long)queryRunner.query(sql,new ScalarHandler());
            System.out.println(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
