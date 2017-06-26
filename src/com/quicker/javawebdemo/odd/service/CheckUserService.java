package com.quicker.javawebdemo.odd.service;

import com.quicker.javawebdemo.odd.dao.UserDao;
import com.quicker.javawebdemo.odd.dao.impl.UserDaoImpl;
import com.quicker.javawebdemo.odd.entity.User;
import com.quicker.javawebdemo.odd.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zy_git on 2017/6/9.
 */
public class CheckUserService {

    private UserDao userDao = new UserDaoImpl();

    public boolean check(User user) {
        Connection conn = ConnectionFactory.getInstance().makeConnection();
        try {
            conn.setAutoCommit(false);
            ResultSet rs = userDao.get(conn, user);

            while (rs.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
