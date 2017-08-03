package com.yungo.entity;

/**
 * Created by cx on 17-8-3.
 */
public class User {
    Integer id;
    String username;
    String password;
    long phone;

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

    public void setPhone(long phone){
        this.phone=phone;
    }
    public long getPhone(){
        return phone;
    }
}
