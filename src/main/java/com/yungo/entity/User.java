package com.yungo.entity;

import java.io.Serializable;

/**
 * Created by cx on 17-8-3.
 */

public class User implements Serializable {
    Integer id;
    String nickname;
    String password;
    long phone;
    String roles;

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", phone=" + phone +
                '}';
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
