package com.vincentliong.model;

import java.util.ArrayList;


/**
 * Created by RongMa on 16/3/24.
 */
public class User {
    private String userId;       //用户id
    private String userName;     //用户名
    private String displayPath;    //头像
    private ArrayList<String> friends;  //好友id

    public User() {
    }

    public User(String displayPath, ArrayList<String> friends, String userId, String userName) {
        this.displayPath = displayPath;
        this.friends = friends;
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

    public ArrayList<String> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<String> friends) {
        this.friends = friends;
    }

}
