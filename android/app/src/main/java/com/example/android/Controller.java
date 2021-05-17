package com.example.android;

import java.util.ArrayList;

public class Controller {

    public ArrayList<User> userList= new ArrayList<User>();
    public ArrayList<Delivery> deliveries= new ArrayList<Delivery>();

    public Controller(ArrayList<User> userList) {

        this.userList = userList;
    }

    //add a new mailman
    public void addMailman(String name,String password) {
        Mailman mailman=new Mailman(name,password);
        userList.add(mailman);
    }

    //add a new receiver
    public void addReceiver(String name,String password, String address) {
        Receiver receiver=new Receiver(name,password, address);
        userList.add(receiver);
    }
    // delivery: ID confirmation(yes:no)
    public void createDelivery(Mailman mailman,Receiver receiver){
        Delivery delivery=new Delivery(mailman.getID(),mailman.getUserName(),receiver.getID(),receiver.getUserName());
        deliveries.add(delivery);
    }

    public void expectDelivery(Mailman mailman, Receiver receiver){
        String content="You have a mail ready to be delivered to you, please wait for it it's on it's way to you! Vroom vroom !";
        Message message=new Message(content,mailman.getUserName(),receiver.getUserName());
        receiver.getNotification().add(message);
    }
    public void pickupMessage(Mailman mailman, Receiver receiver,Delivery delivery){
        String content="Your mail has arrived and waits for you ! please confirm pickup :) ";
        Message message=new Message(content,mailman.getUserName(),receiver.getUserName());
        receiver.getNotification().add(message);
        delivery.setStatus("Delivered");
    }

    public void ConfirmPickupMessage(Mailman mailman, Receiver receiver,Delivery delivery){
        String content="Pickup Confirmed!";
        delivery.setStatus("Picked-up");
        Message message=new Message(content,mailman.getUserName(),receiver.getUserName());
        mailman.getNotification().add(message);
    }

}