package com.example.android;

import java.util.UUID;

public class Message {
    private String ID;
    private String title;
    private String content;
    private String senderID;
    private String senderName;
    //private String receiverName;
    private String messageStatus;

    public Message(String title, String content, String senderID, String senderName) {
        UUID uuid = UUID.randomUUID();
        this.ID = uuid.toString();
        this.ID = ID.substring(0, Math.min(ID.length(), 3));

        this.title=title;
        this.content = content;
        this.senderID=senderID;
        this.senderName = senderName;
       // this.receiverName = receiverName;

        this.messageStatus="";
    }

    public String getID() {
        return ID;
    }

    public String getContent() {
        return content;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    //public String getReceiverName() {return receiverName;}

   /* public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }*/


    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }



    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }



    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }


    @Override
    public String toString() {
        return "Message{" +
                "ID='" + ID + '\'' +
                ", content='" + title + '\''+
                ", content='" + content + '\'' +
                ", sender='" + senderName + '\'' +
           //     ", receiver='" + receiverName + '\'' +
                '}';
    }
}
