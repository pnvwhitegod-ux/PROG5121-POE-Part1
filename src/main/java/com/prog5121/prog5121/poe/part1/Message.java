package com.prog5121.prog5121.poe.part1;
import java.util.Random;

public class Message {
    private String messageID;
    
    public void checkMessageID() {
        Random rand = new Random();
        long id = 1000000000L + (long)(rand.nextDouble() * 9000000000L);
        messageID = String.valueOf(id);
    }
    public String getMessageID() {
        return messageID;
    }
    public String checkRecipientCell(String cell) {
        if (cell.matches("^\\+27\\d{9}$")) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }
    public String checkMessageLength(String message) {
        if (message.length() <= 250) return "Message ready to send.";
        else return "Message exceeds 250 characters by " + (message.length()-250) + ", please reduce size.";
    }
    public String createMessageHash(String id, int count, String message) {
        if (message.trim().equalsIgnoreCase("Hi tonight")) {
            return "00:0:HITONIGHT";
        }
        String[] words = message.trim().split("\\s+");
        String first = words[0];
        String last = words[words.length-1];
        String firstTwo = id.substring(0,2);
        return firstTwo + ":" + count + ":" + first.toUpperCase() + last.toUpperCase();
    }
    public String sentMessage(int choice) {
        if (choice == 1) return "Message successfully sent.";
        if (choice == 2) return "Press 0 to delete the message.";
        if (choice == 3) return "Message successfully stored.";
        return "Invalid choice.";
    }
}