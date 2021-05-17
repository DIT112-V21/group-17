package com.example.android;

public class Receiver extends User {
    private String address;

    public Receiver(String userName, String passWord, String address) {
        super( userName, passWord);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
