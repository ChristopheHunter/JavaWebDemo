package com.quicker.javawebdemo.dao;

import com.quicker.javawebdemo.entity.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by zy_git on 2017/6/7.
 */
public interface TestDao {

    void insertTest(Connection connection, Test test) throws SQLException;

}
