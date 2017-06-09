package com.quicker.javawebdemo.dao.impl;

import com.quicker.javawebdemo.dao.UserDao;
import com.quicker.javawebdemo.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zy_git on 2017/6/8.
 */
public class UserDaoImpl implements UserDao {

    /**
     * 将User对象中的信息存放到数据库的表中
     *
     * @param conn
     * @param user
     * @throws SQLException
     */
    @Override
    public void save(Connection conn, User user) throws SQLException {
        String sql = "INSERT INTO tbl_user(name,password,email) VALUES (?, ?,?)";
        PreparedStatement ps = conn.prepareCall(sql);
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.execute();
    }

    /**
     * 更具用户制定的ID更新用户信息
     *
     * @param conn
     * @param id
     * @param user
     * @throws SQLException
     */
    @Override
    public void update(Connection conn, Long id, User user) throws SQLException {
        String sql = "UPDATE tbl_user set name = ?,password = ?,email = ?,WHERE id = ?";
        PreparedStatement ps = conn.prepareCall(sql);
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.setLong(4, id);
        ps.execute();
    }

    /**
     * 删除指定的用户信息
     *
     * @param conn
     * @param user
     * @throws SQLException
     */
    @Override
    public void delete(Connection conn, User user) throws SQLException {
        String sql = "DELETE FROM tbl_user WHERE id = ?";
        PreparedStatement ps = conn.prepareCall(sql);
        ps.setLong(1, user.getId());
        ps.execute();
    }

    @Override
    public ResultSet get(Connection conn, User user) throws SQLException {
        String sql = "SELECT * FROM tbl_user WHERE name = ? and password = ?";
        PreparedStatement ps = conn.prepareCall(sql);
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        return ps.executeQuery();
    }
}
