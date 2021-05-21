package com.example.android;

import java.util.ArrayList;
import java.util.UUID;

public class Mailman {

    private String ID;
    private String userName;
    private String passWord;

    private ArrayList<Message> notifications;

    public Mailman(String userName,String passWord){
        UUID uuid = UUID.randomUUID();
        this.ID = uuid.toString();
        this.ID = ID.substring(0, Math.min(ID.length(), 3));

        this.userName=userName;
        this.passWord=passWord;
        this.notifications= new ArrayList<Message>();
    }

    public String getID() {

        return ID;
    }

    public String getName() {

        return userName;
    }

    public void setName(String userName) {

        this.userName = userName;
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




    @Override
    public String toString() {
        return "Mailman{" +
                "ID='" + ID + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

}
