package com.quicker.javawebdemo.odd.entity;

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
