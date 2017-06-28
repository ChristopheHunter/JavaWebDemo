package com.quicker.javawebdemo.domain;

/**
 * Created by zy_git on 2017/6/28.
 */
public class User {

    public User(){

    }

    private int uid;
    private String uname;
    private String upassword;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }
}
