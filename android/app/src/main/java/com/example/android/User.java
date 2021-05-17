package com.example.android;

import java.util.ArrayList;
import java.util.UUID;

public abstract class User {

    private String ID;
    private String userName;
    private String passWord;

    private ArrayList<Message> notification;

    public User(String userName,String passWord){
        UUID uuid = UUID.randomUUID();
        this.ID = uuid.toString();
        this.ID = ID.substring(0, Math.min(ID.length(), 3));

        this.userName=userName;
        this.passWord=passWord;
        this.notification= new ArrayList<Message>();
    }

    public String getID() {
        return ID;
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
