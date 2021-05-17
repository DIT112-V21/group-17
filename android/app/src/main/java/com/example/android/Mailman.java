package com.example.android;

public class Mailman extends User{
    public Mailman( String userName, String passWord) {

        super(userName, passWord);
    }

    @Override
    public String toString() {
        return "Mailman{} " + super.toString();
    }
}
