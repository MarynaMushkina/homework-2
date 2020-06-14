package com.udemy.models;

import org.openqa.selenium.Cookie;

public class User {
    private String name;
    private String email;
    private String password;
    private String userLbl;
    private Cookie cookie;

    public User() {}

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setUserLbl(String userLbl) {
        this.userLbl = userLbl;
        return this;
    }

    public User setCookie(Cookie cookie) {
        this.cookie = cookie;
        return this;
    }
    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUserLbl() {
        return this.userLbl;
    }

    public Cookie getCookie() {
        return this.cookie;
    }
}
