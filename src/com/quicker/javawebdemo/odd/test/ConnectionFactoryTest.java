package com.quicker.javawebdemo.odd.test;

import com.quicker.javawebdemo.odd.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by zy_git on 2017/6/7.
 */
public class ConnectionFactoryTest {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = ConnectionFactory.getInstance();
        Connection conn = factory.makeConnection();
        System.out.println(conn.getAutoCommit());
    }

}
