package com.quicker.javawebdemo.entity;

import sun.rmi.runtime.Log;

/**
 * Created by zy_git on 2017/6/7.
 */
public abstract class IdEntity {

    protected Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
