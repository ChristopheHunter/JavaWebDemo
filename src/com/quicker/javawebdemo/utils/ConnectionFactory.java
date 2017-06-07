package com.quicker.javawebdemo.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by zy_git on 2017/6/7.
 */
public class ConnectionFactory {

    private static String driver;
    private static String dburl;
    private static String user;
    private static String password;

    private static final ConnectionFactory factory = new ConnectionFactory();

    private Connection conn;

    //用于初始化类
    static{
        Properties prop = new Properties();
        try{
            InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream("db_config.properties");
            prop.load(in);      //读取属性文件中的键值对信息
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("==================配置文件读取错误==================");
        }

        driver = prop.getProperty("driver");
        dburl = prop.getProperty("dburl");
        user = prop.getProperty("user");
        password = prop.getProperty("password");
    }

    private ConnectionFactory(){

    }

    public static ConnectionFactory getInstance(){
        return factory;
    }

    public  Connection makeConnection(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(dburl,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
