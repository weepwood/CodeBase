package com.halo.pojo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Halo
 * @date Created in 2020/11/07  11:08
 * @description
 */
@Getter
@Setter
@ToString
public class User {
    private int id;
    private String name;
    private String password;

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.password = pwd;
    }

    public User() {
    }
}
