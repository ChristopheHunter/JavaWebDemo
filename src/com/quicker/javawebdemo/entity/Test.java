package com.quicker.javawebdemo.entity;

/**
 * Created by zy_git on 2017/6/7.
 */
public class Test extends IdEntity{
    private String name;
    private String email;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Test{" +
                "email='" + email + '\'' +
                ", id=" + id +
                '}';
    }
}
