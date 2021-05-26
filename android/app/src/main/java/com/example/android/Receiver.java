package com.example.android;


import java.util.ArrayList;
import java.util.UUID;

public class Receiver {

    private String ID;
    private String name;
    private String passWord;
    private String address;
    private String loginStatus;

    private ArrayList<Message> notifications;


    public Receiver(String name, String passWord, String address){
        UUID uuid = UUID.randomUUID();
        this.ID = uuid.toString();
        this.ID = ID.substring(0, Math.min(ID.length(), 3));

        this.name=name;
        this.passWord=passWord;
        this.address=address;
        this.notifications= new ArrayList<Message>();
        this.loginStatus="logged_Out";
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String userName) {
        this.name = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public ArrayList<Message> getNotifications() {
        return notifications;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "ID='" + ID + '\'' +
                ", userName='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}

