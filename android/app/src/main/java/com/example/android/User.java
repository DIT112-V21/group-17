package com.example.android;

import java.util.ArrayList;

public abstract class User {

    private String ID;
    private String userName;
    private String passWord;

    private ArrayList<Message> notification;

    public User(String ID,String userName,String passWord){
        this.ID=ID;
        this.userName=userName;
        this.passWord=passWord;
        this.notification= new ArrayList<Message>();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public ArrayList<Message> getNotification() {
        return notification;
    }

    public void setNotification(ArrayList<Message> notification) {
        this.notification = notification;
    }


    @Override
    public String toString() {
        return "User{" +
                "ID='" + ID + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
