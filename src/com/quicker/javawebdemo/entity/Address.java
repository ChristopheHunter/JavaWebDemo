package com.quicker.javawebdemo.entity;

/**
 * Created by zy_git on 2017/6/7.
 */
public class Address extends IdEntity{

    private String city;
    private String country;
    private Long user_id;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", id=" + id +
                ", country='" + country + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
