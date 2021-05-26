package com.example.android;

import java.util.ArrayList;

public class Controller {

    public static ArrayList<Receiver> receiversList = new ArrayList<Receiver>();
    public static ArrayList<Mailman> mailmenList = new ArrayList<Mailman>();
    public static ArrayList<Delivery> deliveries = new ArrayList<Delivery>();

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
    /* // test if the mailman receives messages
    public static void addMailmanMessage(String name, String password) {
        Mailman mailman = new Mailman(name, password);
        mailmenList.add(mailman);
        Message message=new Message("Hi","Leila",mailman.getID(),mailman.getName());
        mailman.getNotifications().add(message);
    }
    */


    //add a new receiver
    public static void addReceiver(String name, String password, String address) {
        Receiver receiver = new Receiver(name, password, address);
        receiversList.add(receiver);
    }


    //add expect message to the mailman's list of messages and creates a delivery
    public static void sendExpectDelivery(Mailman mailman, Receiver receiver) {
        //createDelivery(mailman, receiver);
        //expect: sent; pickup: sent
        String title="Expect";
        String content = "You have a mail ready to be delivered to you, please wait for it it's on it's way to you! Vroom vroom !";
        Message message = new Message(title,content, mailman.getID(),mailman.getName());//receiver.getName());
        receiver.getNotifications().add(message);
    }

    public static void sendPickupMessage(Mailman mailman, String receiverID) {
        String title="Confirm pick-up";
        String content = "Your mail has arrived and waits for you ! please confirm pick-up :) ";
        int receiverPosition=fetchReceiverByIDInAList(receiverID);
        System.out.println(mailman.getID());
        System.out.println(mailman.getName());
//        System.out.println(receiver.getName());

        Message message = new Message(title,content, mailman.getID(),mailman.getName());   //receiver.getName());
        receiversList.get(receiverPosition).getNotifications().add(message);
        //delivery.setStatus("Delivered");
    }

    public static void confirmPickupMessage(Mailman mailman, Receiver receiver) {
        //(Mailman mailman, Receiver receiver, Delivery delivery)
        String title="Confirmed pick-up";
        String content = "Pickup Confirmed by "+receiver.getName();
        //delivery.setStatus("Picked-up");
        Message message = new Message(title,content, receiver.getID(),receiver.getName());//mailman.getName());
        mailman.getNotifications().add(message);
    }

    public static void available(Mailman mailman, Receiver receiver) {
        //(Mailman mailman, Receiver receiver, Delivery delivery)
        String title="Available";
        String content = receiver.getName()+"is not available to pick up the delivery";
        //delivery.setStatus("Picked-up");
        Message message = new Message(title,content, receiver.getID(),receiver.getName());//mailman.getName());
        mailman.getNotifications().add(message);
    }

    public static void notAvailable(Mailman mailman, Receiver receiver) {
        //(Mailman mailman, Receiver receiver, Delivery delivery)
        String title="Not available";
        String content = receiver.getName()+"is available to pick up the delivery";
        //delivery.setStatus("Picked-up");
        Message message = new Message(title,content, receiver.getID(),receiver.getName());//mailman.getName());
        mailman.getNotifications().add(message);
    }

    public static void available(Mailman mailman, Receiver receiver) {
        //(Mailman mailman, Receiver receiver, Delivery delivery)
        String title="Available";
        String content = receiver.getName()+"is not available to pick up the delivery";
        //delivery.setStatus("Picked-up");
        Message message = new Message(title,content, receiver.getID(),receiver.getName(),mailman.getName());
        mailman.getNotifications().add(message);
    }

    public static void notAvailable(Mailman mailman, Receiver receiver) {
        //(Mailman mailman, Receiver receiver, Delivery delivery)
        String title="Not available";
        String content = receiver.getName()+"is available to pick up the delivery";
        //delivery.setStatus("Picked-up");
        Message message = new Message(title,content, receiver.getID(),receiver.getName(),mailman.getName());
        mailman.getNotifications().add(message);
    }

    public static void mailmanLogOut(){
        for (Mailman mailman:mailmenList){
            if (mailman.getLoginStatus().equals("logged_in")){
                mailman.setLoginStatus("logged_Out");
            }
        }
    }
    public static void receiverLogOut(){
        for (Receiver receiver:receiversList){
            if (receiver.getLoginStatus().equals("logged_in")){
                receiver.setLoginStatus("logged_Out");
            }
        }
    }


    public static boolean verifyMailmanCredentials(String name, String password){
        for (Mailman mailman:mailmenList){
            if ((mailman.getName().equals(name)) &&(mailman.getPassWord().equals(password))){
                mailman.setLoginStatus("logged_in");
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Message> mailmanMessageList(){
        for (Mailman mailman:mailmenList) {
            if (mailman.getLoginStatus().equals("logged_in")){
                return mailman.getNotifications();
            }

        }
        return null;
    }

    public static ArrayList<Message> receiverMessageList(){
        for (Receiver receiver: receiversList) {
            if (receiver.getLoginStatus().equals("logged_in")){
                return receiver.getNotifications();
            }

        }
        return null;
    }

    public static Receiver getLoggedInReceiver(){
        for (Receiver receiver: receiversList) {
            if (receiver.getLoginStatus().equals("logged_in")){
                return receiver;
            }
        }
        return null;
    }

    public static boolean verifyReceiverCredentials(String name, String password){
        for (Receiver receiver:receiversList){
            if ((receiver.getName().equals(name)) &&(receiver.getPassWord().equals(password))){
                receiver.setLoginStatus("logged_in");
                return true;
            }
        }
        return false;
    }

    /*
    public static Mailman searchMailManById(String mailmanID){
        for (Mailman mailman:mailmenList) {
            if (mailman.getLoginStatus().equals(mailmanID)){
                return mailman;
            }
        }
        return null;
    }
    */
    public static Receiver searchReceiverById(String receiverID){
        for (Receiver receiver:receiversList) {
            if (receiver.getLoginStatus().equals("logged_in")){
                return receiver;
            }
        }
        return null;
    }

    // 17. fetch mailman by ID(if found returns index, else -1)
    public static int fetchReceiverByIDInAList(String receiverID) {
        //-2: empty list, -1: invalid ID, i: index
        if (receiversList.isEmpty()) {
            return -2;
        } else {
            for (int i = 0; i < receiversList.size(); i++) {
                if (receiverID.equals(receiversList.get(i).getID())) {
                    return i;
                }
            }
        }
        return -1;
    }

    // 17. fetch mailman by ID(if found returns index, else -1)
    public static int fetchMailmanByIDInAList(String mailmanID) {
        //-2: empty list, -1: invalid ID, i: index
        if (mailmenList.isEmpty()) {
            return -2;
        } else {
            for (int i = 0; i < mailmenList.size(); i++) {
                if (mailmanID.equals(mailmenList.get(i).getID())) {
                    return i;
                }
            }
        }
        return -1;
    }

    // mailman object (project/task)
    public static Mailman mailmanFromID(String mailmanID) {
        int indexOfmailman=fetchMailmanByIDInAList(mailmanID);
        if (indexOfmailman>=0) {
            return mailmenList.get(indexOfmailman);
        }
        else {
            return null;
        }
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

    // create a delivery: ID confirmation(yes:no)
    public void createDelivery(Mailman mailman, Receiver receiver) {
        Delivery delivery = new Delivery(mailman.getID(), mailman.getName(), receiver.getID(), receiver.getName());
        deliveries.add(delivery);
    }

}

