package com.chocksaway.domain;

/**
 * Author milesd on 27/04/2019.
 */
public class Detail {
    private String name;
    private String password;


    public Detail(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
