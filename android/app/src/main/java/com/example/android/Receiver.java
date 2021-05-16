package com.example.android;

public class Receiver extends User {
    private String adress;

    public Receiver(String ID, String userName, String passWord, String adress) {
        super(ID, userName, passWord);
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "adress='" + adress + '\'' +
                '}';
    }
}
