package com.example.android;

import java.util.ArrayList;
import java.util.UUID;

public class Mailman {

    private String ID;
    private String name;
    private String passWord;
    private String loginStatus;

    private ArrayList<Message> notifications;

    public Mailman(String name,String passWord){
        UUID uuid = UUID.randomUUID();
        this.ID = uuid.toString();
        this.ID = ID.substring(0, Math.min(ID.length(), 3));

        this.name=name;
        this.passWord=passWord;
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

        this.name = name;
    }

    public String getPassWord() {

        return passWord;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }


    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public ArrayList<Message> getNotifications() {
        return notifications;
    }




    @Override
    public String toString() {
        return "Mailman{" +
                "ID='" + ID + '\'' +
                ", userName='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

}
