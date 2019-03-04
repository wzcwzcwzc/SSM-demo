package com.ssmdemo.dao.entity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author Barry Wang
 * */

@Component
public class UserEntity {

    private int id;
    private String username;
    private String password;


    public UserEntity(){

    }

    public UserEntity(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
