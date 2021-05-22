package com.example.android;

import java.util.ArrayList;

public class Controller {

    public static ArrayList<Receiver> receiversList = new ArrayList<Receiver>();
    public static ArrayList<Mailman> mailmenList = new ArrayList<Mailman>();
    public ArrayList<Delivery> deliveries = new ArrayList<Delivery>();

    public Controller() {
        receiversList = new ArrayList<Receiver>();
        mailmenList = new ArrayList<Mailman>();
        deliveries = new ArrayList<Delivery>();
    }

    //add a new mailman
    public static void addMailman(String name, String password) {
        Mailman mailman = new Mailman(name, password);
        mailmenList.add(mailman);
    }

    //add a new receiver
    public static void addReceiver(String name, String password, String address) {
        Receiver receiver = new Receiver(name, password, address);
        receiversList.add(receiver);
    }

    // create a delivery: ID confirmation(yes:no)
    public void createDelivery(Mailman mailman, Receiver receiver) {
        Delivery delivery = new Delivery(mailman.getID(), mailman.getName(), receiver.getID(), receiver.getName());
        deliveries.add(delivery);
    }

    //add expect message to the mailman's list of messages and creates a delivery
    public void sendExpectDelivery(Mailman mailman, Receiver receiver) {
        createDelivery(mailman, receiver);
        String content = "You have a mail ready to be delivered to you, please wait for it it's on it's way to you! Vroom vroom !";
        Message message = new Message(content, mailman.getName(), receiver.getName());
        receiver.getNotifications().add(message);
    }

    public void sendPickupMessage(Mailman mailman, Receiver receiver, Delivery delivery) {
        String content = "Your mail has arrived and waits for you ! please confirm pickup :) ";
        Message message = new Message(content, mailman.getName(), receiver.getName());
        receiver.getNotifications().add(message);
        delivery.setStatus("Delivered");
    }

    public void ConfirmPickupMessage(Mailman mailman, Receiver receiver, Delivery delivery) {
        String content = "Pickup Confirmed!";
        delivery.setStatus("Picked-up");
        Message message = new Message(content, mailman.getName(), receiver.getName());
        mailman.getNotifications().add(message);
    }

    public Mailman isLoggedIn(String name, String password){
        for (Mailman mailman:mailmenList){
            if ((mailman.getName().equals(name)) &&(mailman.getPassWord().equals(password))){
                return mailman;
            }
        }
        return null;
    }


    public static boolean verifyMailmanCredentials(String name, String password){
        for (Mailman mailman:mailmenList){
            if ((mailman.getName().equals(name)) &&(mailman.getPassWord().equals(password))){
                return true;
            }
        }
        return false;
    }

    public boolean verifyReceiverCredentials(String name, String password){
        for (Receiver receiver:receiversList){
            if ((receiver.getName().equals(name)) &&(receiver.getPassWord().equals(password))){
                return true;
            }
        }
        return false;
    }


    //************************************************************************

    // Display the list of deliveries (history)
    public void displayListOfDeliveries() {
        if (deliveries.isEmpty()) {
            System.out.println("No data to show");
        } else {
            for (Delivery delivery : deliveries) {
                System.out.println(delivery);
            }
        }
    }

}

