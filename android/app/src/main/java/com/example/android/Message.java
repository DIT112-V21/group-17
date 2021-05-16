package com.example.android;

public class Message {
    private String ID;
    private String content;

    public Message(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }



    @Override
    public String toString() {
        return "Message{" +
                "ID='" + ID + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
