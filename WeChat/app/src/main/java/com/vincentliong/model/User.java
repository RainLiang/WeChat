package com.vincentliong.model;

import java.util.ArrayList;


/**
 * Created by RongMa on 16/3/24.
 */
public class User {
    private String userId;       //用户id
    private String userName;     //用户名
    private String displayPath;    //头像

    public User() {
    }

    public User(String displayPath, ArrayList<String> friends, String userId, String userName) {
        this.displayPath = displayPath;
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayPath() {
        return displayPath;
    }

    public void setDisplayPath(String displayPath) {
        this.displayPath = displayPath;
    }
}
