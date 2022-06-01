package com.sykking.entity;

import java.util.Date;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String sex;
    private String icon;
    private Date borndate;

    public User(String username, String password, String sex, String icon, Date borndate) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.icon = icon;
        this.borndate = borndate;
    }

    public User(Integer id, String username, String password, String sex, String icon, Date borndate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.icon = icon;
        this.borndate = borndate;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", icon='" + icon + '\'' +
                ", borndate=" + borndate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Date getBorndate() {
        return borndate;
    }

    public void setBorndate(Date borndate) {
        this.borndate = borndate;
    }
}
