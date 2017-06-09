package com.quicker.javawebdemo.dao;

import com.quicker.javawebdemo.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zy_git on 2017/6/7.
 */
public interface UserDao {

    //保护用户数据的方法
    public void save(Connection conn, User user) throws SQLException;

    public void update(Connection conn, Long id, User user) throws SQLException;

    public void delete(Connection conn,User user) throws SQLException;

    public ResultSet get(Connection conn,User user) throws SQLException;

}
