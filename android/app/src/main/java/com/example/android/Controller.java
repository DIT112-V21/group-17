package com.example.android;

import java.util.ArrayList;

public class Controller {

    public static ArrayList<Receiver> receiversList = new ArrayList<Receiver>();
    public static ArrayList<Mailman> mailmenList = new ArrayList<Mailman>();

    public Controller() {
        receiversList = new ArrayList<Receiver>();
        mailmenList = new ArrayList<Mailman>();
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


    //Send expect a delivery to the receiver: adds expect message to the receiver's list of messages
    public static void sendExpectDelivery(String mailmanID, Receiver receiver) {
        String title="Expect";
        String content = "You have a mail ready to be delivered to you, please wait for it it's on it's way to you! Vroom vroom !";
        int mailmanPosition=fetchMailmanByIDInAList(mailmanID);
        String mailmanName=mailmenList.get(mailmanPosition).getName();
        Message message = new Message(title,content, mailmanID,mailmanName);
        receiver.getNotifications().add(message);
    }

    //Send pickup delivery to the receiver: adds pickup message to the receiver's list of messages
    public static void sendPickupMessage(String mailmanID, String receiverID) {
        String title="Confirm pick-up";
        String content = "Your mail has arrived and waits for you ! please confirm pick-up :) ";
        int receiverPosition=fetchReceiverByIDInAList(receiverID);
        int mailmanPosition=fetchMailmanByIDInAList(mailmanID);
        String mailmanName=mailmenList.get(mailmanPosition).getName();
        Message message = new Message(title,content, mailmanID,mailmanName);
        receiversList.get(receiverPosition).getNotifications().add(message);
    }

    //Send a confirmation of pickup of delivery to the mailman: adds confirmation message to the mailman's list of messages
    public static void confirmPickupMessage(Mailman mailman, Receiver receiver) {
        String title="Confirmed pick-up";
        String content = "Pickup Confirmed by "+receiver.getName();
        //delivery.setStatus("Picked-up");
        Message message = new Message(title,content, receiver.getID(),receiver.getName());
        mailman.getNotifications().add(message);
    }

    //Send a message to the mailman to inform that the receiver is available: adds expect message to the mailman's list of messages
    public static void available(Mailman mailman, Receiver receiver) {
        String title="Available";
        String content = receiver.getName()+"is not available to pick up the delivery";
        Message message = new Message(title,content, receiver.getID(),receiver.getName());
        mailman.getNotifications().add(message);
    }

    //Send a message to the mailman to inform that the receiver is not available: adds expect message to the mailman's list of messages
    public static void notAvailable(Mailman mailman, Receiver receiver) {
        String title="Not available";
        String content = receiver.getName()+"is not available to pick up the delivery";
        Message message = new Message(title,content, receiver.getID(),receiver.getName());
        mailman.getNotifications().add(message);
    }

    // Logout: mailman
    public static void mailmanLogOut(){
        for (Mailman mailman:mailmenList){
            if (mailman.getLoginStatus().equals("logged_in")){
                mailman.setLoginStatus("logged_Out");
            }
        }
    }

    // Logout: receiver
    public static void receiverLogOut(){
        for (Receiver receiver:receiversList){
            if (receiver.getLoginStatus().equals("logged_in")){
                receiver.setLoginStatus("logged_Out");
            }
        }
    }

    // Verify the mailman's credentials to connect as a mailman
    public static boolean verifyMailmanCredentials(String name, String password){
        for (Mailman mailman:mailmenList){
            if ((mailman.getName().equals(name)) &&(mailman.getPassWord().equals(password))){
                mailman.setLoginStatus("logged_in");
                return true;
            }
        }
        return false;
    }


    // Verify the receiver's credentials to connect as a receiver
    public static boolean verifyReceiverCredentials(String name, String password){
        for (Receiver receiver:receiversList){
            if ((receiver.getName().equals(name)) &&(receiver.getPassWord().equals(password))){
                receiver.setLoginStatus("logged_in");
                return true;
            }
        }
        return false;
    }

    // Get the list of messages that the mailman who is connected received
    public static ArrayList<Message> mailmanMessageList(){
        for (Mailman mailman:mailmenList) {
            if (mailman.getLoginStatus().equals("logged_in")){
                return mailman.getNotifications();
            }

        }
        return null;
    }


    // Get the list of messages that the receiver who is connected received
    public static ArrayList<Message> receiverMessageList(){
        for (Receiver receiver: receiversList) {
            if (receiver.getLoginStatus().equals("logged_in")){
                return receiver.getNotifications();
            }

        }
        return null;
    }

    // get the logged in receiver ID
    public static Receiver getLoggedInReceiver(){
        for (Receiver receiver: receiversList) {
            if (receiver.getLoginStatus().equals("logged_in")){
                return receiver;
            }
        }
        return null;
    }

    // Get the logged in mailman ID
    public static String getLoggedInMailmanID(){
        for (Mailman mailman: mailmenList) {
            if (mailman.getLoginStatus().equals("logged_in")){
                return mailman.getID();
            }
        }
        return null;
    }

    // Fetch receiver by ID(if found returns index, else -1)
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

    // Fetch mailman by ID(if found returns index, else -1)
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

    // mailman object
    public static Mailman mailmanFromID(String mailmanID) {
        int indexOfmailman=fetchMailmanByIDInAList(mailmanID);
        if (indexOfmailman>=0) {
            return mailmenList.get(indexOfmailman);
        }
        else {
            return null;
        }
    }


}

