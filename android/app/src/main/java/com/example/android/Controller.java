package com.example.android;

import java.util.ArrayList;

public class Controller {

    public ArrayList<User> userList = new ArrayList<User>();
    public ArrayList<Delivery> deliveries = new ArrayList<Delivery>();

    public Controller() {
        userList = new ArrayList<User>();
        deliveries = new ArrayList<Delivery>();
    }

    //add a new mailman
    public void addMailman(String name, String password) {
        Mailman mailman = new Mailman(name, password);
        userList.add(mailman);
    }

    //add a new receiver
    public void addReceiver(String name, String password, String address) {
        Receiver receiver = new Receiver(name, password, address);
        userList.add(receiver);
    }

    // create a delivery: ID confirmation(yes:no)
    public void createDelivery(Mailman mailman, Receiver receiver) {
        Delivery delivery = new Delivery(mailman.getID(), mailman.getUserName(), receiver.getID(), receiver.getUserName());
        deliveries.add(delivery);
    }

    //add expect message to the mailman's list of messages and creates a delivery
    public void sendExpectDelivery(Mailman mailman, Receiver receiver) {
        createDelivery(mailman, receiver);
        String content = "You have a mail ready to be delivered to you, please wait for it it's on it's way to you! Vroom vroom !";
        Message message = new Message(content, mailman.getUserName(), receiver.getUserName());
        receiver.getNotifications().add(message);
    }

    public void sendPickupMessage(Mailman mailman, Receiver receiver, Delivery delivery) {
        String content = "Your mail has arrived and waits for you ! please confirm pickup :) ";
        Message message = new Message(content, mailman.getUserName(), receiver.getUserName());
        receiver.getNotifications().add(message);
        delivery.setStatus("Delivered");
    }

    public void ConfirmPickupMessage(Mailman mailman, Receiver receiver, Delivery delivery) {
        String content = "Pickup Confirmed!";
        delivery.setStatus("Picked-up");
        Message message = new Message(content, mailman.getUserName(), receiver.getUserName());
        mailman.getNotifications().add(message);
    }

    //Display messages(both mailman and receiver)
    public void displayListOfMessages(User user) {
        if (user.getNotifications().isEmpty()) {
            System.out.println("No messages to show");
        } else {
            for (Message message : user.getNotifications()) {
                System.out.println(message);
            }
        }
    }

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


    public void displayListOfReceivers() {
        int countReceivers = 0;

        if (countReceivers()>0) {
            for (User user : userList) {
                if (user instanceof Receiver) {
                    System.out.println(user);
                }
            }
        }
    }

    // Method that counts the number of receivers in the list of users
    public int countReceivers() {
        // check the list of receivers (if empty)
        if (userList.isEmpty()) {
            System.out.println("No data to display!");
            return -1;
        } else {
            //Count receivers
            int receiversCounter = 0;
            for (User user : userList) {
                if (user instanceof Receiver) {
                    receiversCounter++;
                }
            }
            if (receiversCounter == 0) {
                System.err.println("No data to display!");
            }
            return receiversCounter;
        }
    }
}

