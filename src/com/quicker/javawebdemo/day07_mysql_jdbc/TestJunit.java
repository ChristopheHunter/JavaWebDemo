package com.quicker.javawebdemo.day07_mysql_jdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zy_git on 2017/6/26.
 */
public class TestJunit {

    public static void main(String[] args){
        System.out.println("Hello,World");
    }

    @Test
    public void testJunit(){
        System.out.println("Hello,Junit");
    }
    @Test
    public void testJunit2(){
        System.out.println("Hello,Junit2");
    }

    @Before
    public void testBefore(){
        System.out.println("before");
    }

    @After
    public void testAfter(){
        System.out.println("after");
    }

}
