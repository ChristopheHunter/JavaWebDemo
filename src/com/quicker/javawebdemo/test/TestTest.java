package com.quicker.javawebdemo.test;

import com.quicker.javawebdemo.dao.TestDao;
import com.quicker.javawebdemo.dao.impl.TestImpl;
import com.quicker.javawebdemo.entity.Test;
import com.quicker.javawebdemo.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by zy_git on 2017/6/7.
 */
public class TestTest {

    public static void main(String[] args){
        Test test = new Test();
        test.setName("C");
        test.setEmail("1041433080@qq.com");
        TestDao testdao = new TestImpl();

        Connection conn = ConnectionFactory.getInstance().makeConnection();
        try {
            testdao.insertTest(conn,test);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
