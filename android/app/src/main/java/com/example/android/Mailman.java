package com.example.android;

public class Mailman extends User{
    public Mailman(String ID, String userName, String passWord) {
        super(ID, userName, passWord);
    }

    @Override
    public String toString() {
        return "Mailman{} " + super.toString();
    }
}
