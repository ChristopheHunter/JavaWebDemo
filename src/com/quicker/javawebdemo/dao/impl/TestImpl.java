package com.quicker.javawebdemo.dao.impl;

import com.quicker.javawebdemo.dao.TestDao;
import com.quicker.javawebdemo.entity.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by zy_git on 2017/6/7.
 */
public class TestImpl implements TestDao {

    /**
     * 向test表中插入一条数据
     *
     * @param connection
     * @param test
     */
    @Override
    public void insertTest(Connection connection, Test test) throws SQLException {
        String sql = "INSERT INTO test(name,email) values(?,?)";
        PreparedStatement ps = connection.prepareCall(sql);
        ps.setString(1,test.getName());
        ps.setString(2,test.getEmail());
        ps.execute();
    }
}


