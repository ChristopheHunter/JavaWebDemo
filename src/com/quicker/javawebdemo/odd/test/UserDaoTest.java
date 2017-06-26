package com.quicker.javawebdemo.odd.test;

import com.quicker.javawebdemo.odd.dao.UserDao;
import com.quicker.javawebdemo.odd.dao.impl.UserDaoImpl;
import com.quicker.javawebdemo.odd.entity.User;
import com.quicker.javawebdemo.odd.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by zy_git on 2017/6/7.
 */
public class UserDaoTest {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);
            UserDao userDao = new UserDaoImpl();
            User wangwu = new User();
            wangwu.setName("WangWu");
            wangwu.setEmail("12121211@11.com");
            wangwu.setPassword("123");

            userDao.save(conn,wangwu);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

}
