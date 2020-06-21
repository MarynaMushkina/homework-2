package com.udemy.testdata;

import com.udemy.models.User;
import org.openqa.selenium.Cookie;

import java.sql.Date;

public interface UserData {

    Cookie cookie = new Cookie.Builder("dj_session_id", "0op2mpxwyc7att7uddbx3lh95yfyrc7i")
            .domain("www.udemy.com")
            .expiresOn(new Date(2020, 06, 16))
            .isHttpOnly(true)
            .isSecure(false)
            .path("/")
            .build();

    User baseUser = new User ()
            .setCookie(cookie)
            .setEmail("maryna.mushkina+"+System.currentTimeMillis()+"@gmail.com")
            .setPassword(":h>L(3,b9D3Dz")
            .setName("Maryna");
}