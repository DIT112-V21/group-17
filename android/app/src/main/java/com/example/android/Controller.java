package com.example.android;

import java.util.ArrayList;

public class Controller {

    public ArrayList<User> userList= new ArrayList<User>();

    public Controller(ArrayList<User> userList) {
        this.userList = userList;
    }

    //add a new mailman
    public void addMailman(String ID,String name,String password) {
        Mailman mailman=new Mailman(ID,name,password);
        userList.add(mailman);
    }

    //add a new receiver
    public void addReceiver(String ID,String name,String password, String address) {
        Receiver receiver=new Receiver(ID,name,password, address);
        userList.add(receiver);
    }
    // delivery: ID confirmation(yes:no)

    public void expectDelivery(Mailman mailman, Receiver receiver){
        String Id="12";
        String content="You have a mail ready to be delivered to you, please wait for it it's on it's way to you! Vroom vroom !";
        Message message=new Message(Id,content,mailman.getUserName(),receiver.getUserName());
        receiver.getNotification().add(message);
    }
    public void pickupMessage(Mailman mailman, Receiver receiver){
        String Id="12";
        String content="Your mail has arrived and waits for you ! please confirm pickup :) ";
        Message message=new Message(Id,content,mailman.getUserName(),receiver.getUserName());
        receiver.getNotification().add(message);
    }

    public void ConfirmPickupMessage(Mailman mailman, Receiver receiver){
        String Id="12";
        String content="Your mail has arrived and waits for you ! please confirm pickup :) ";
        Message message=new Message(Id,content,mailman.getUserName(),receiver.getUserName());
        mailman.getNotification().add(message);
    }

}
