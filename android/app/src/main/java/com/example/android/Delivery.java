package com.example.android;

import java.util.UUID;

public class Delivery {
    private String ID;
    private String mailmanID;
    private String mailmanName;
    private String receiverID;
    private String receiverName;
    private String status;


    public Delivery(String mailmanID, String mailmanName, String receiverID, String receiverName) {
        UUID uuid = UUID.randomUUID();
        this.ID = uuid.toString();
        this.ID = ID.substring(0, Math.min(ID.length(), 3));

        this.mailmanID = mailmanID;
        this.mailmanName = mailmanName;
        this.receiverID = receiverID;
        this.receiverName = receiverName;
        this.status = "Not delivered";
    }

    public String getID() {
        return ID;
    }

    public String getMailmanID() {
        return mailmanID;
    }

    public String getMailmanName() {
        return mailmanName;
    }

    public String getReceiverID() {
        return receiverID;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "ID='" + ID + '\'' +
                ", mailmanID='" + mailmanID + '\'' +
                ", mailmanName='" + mailmanName + '\'' +
                ", receiverID='" + receiverID + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
