package com.quicker.javawebdemo.day09_jdbc_dbutils;

import com.quicker.javawebdemo.day08_mysql_jdbc.JDBCUtils_v2;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Created by zy_git on 2017/6/28.
 */
public class MyDataSource implements DataSource {

    private static LinkedList<Connection> pool = new LinkedList<>();

    static {
        for (int i = 0; i < 5; i++) {
            pool.add(new MyConnection(JDBCUtils_v2.getConnection(), pool));
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (pool.size() == 0) {
            for (int i = 0; i < 5; i++) {
                pool.add(new MyConnection(JDBCUtils_v2.getConnection(), pool));
            }
        }
        Connection conn = pool.remove();
        System.out.println("MyDataSource的getConnection方法,此时pool中conn数量：" + pool.size());
        return conn;
    }


    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
