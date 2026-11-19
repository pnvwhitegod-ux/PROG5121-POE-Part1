package com.prog5121.prog5121.poe.part1;

import java.util.ArrayList;

public class MessageManager {
    // PART 3 ARRAYS - Requirement 1
    public ArrayList<String> sentMessages = new ArrayList<>();
    public ArrayList<String> disregardedMessages = new ArrayList<>();
    public ArrayList<String> storedMessages = new ArrayList<>();
    public ArrayList<String> messageHashes = new ArrayList<>();
    public ArrayList<String> messageIDs = new ArrayList<>();
    public ArrayList<String> recipients = new ArrayList<>();
    public ArrayList<String> senders = new ArrayList<>();
    public ArrayList<String> allMessages = new ArrayList<>();

    public void clearAll() {
        sentMessages.clear(); disregardedMessages.clear(); storedMessages.clear();
        messageHashes.clear(); messageIDs.clear(); recipients.clear(); senders.clear(); allMessages.clear();
    }

    // Used to populate arrays from real user input (NOT hard-coded in Main)
    public void addMessage(String id, String recipient, String sender, String message, String flag, String hash) {
        messageIDs.add(id);
        recipients.add(recipient);
        senders.add(sender);
        messageHashes.add(hash);
        allMessages.add(message);
        if (flag.equalsIgnoreCase("Sent")) {
            sentMessages.add(message);
        } else if (flag.equalsIgnoreCase("Stored")) {
            storedMessages.add(message);
        } else if (flag.equalsIgnoreCase("Disregard")) {
            disregardedMessages.add(message);
        }
    }

    // Test Data from Brief Section 3 - ONLY for unit tests and demo
    public void populateTestData() {
        clearAll();
        addMessage("1", "+27834557896", "Vutshila", "Did you get the cake?", "Sent", "00:1:DIDCAKE");
        addMessage("2", "+27838884567", "Vutshila", "Where are you? You are late! I have asked you to be on time.", "Stored", "00:2:WHERETIME");
        addMessage("3", "+27834484567", "Vutshila", "Yohoooo, I am at your gate.", "Disregard", "00:3:YOHOOOOOGATE");
        addMessage("4", "0838884567", "Vutshila", "It is dinner time !", "Sent", "00:4:ITTIME");
        addMessage("5", "+27838884567", "Vutshila", "Ok, I am leaving without you.", "Stored", "00:5:OKYOU");
    }

    public String getMessageByID(String id) {
        for (int i = 0; i < messageIDs.size(); i++) {
            if (messageIDs.get(i).equals(id)) return allMessages.get(i);
        }
        return "";
    }

    // 2a
    public String displaySenderAndRecipient() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < messageIDs.size(); i++) {
            if (storedMessages.contains(allMessages.get(i))) {
                sb.append("Sender: ").append(senders.get(i)).append(", Recipient: ").append(recipients.get(i)).append("\n");
            }
        }
        return sb.toString();
    }

    // 2b - Longest stored message - Test expects Message 2
    public String displayLongestMessage() {
        String longest = "";
        // Check stored first, but brief test uses Message 1-4, longest is stored Message 2
        // To match brief exactly, check all stored + sent for longest in test data set
        ArrayList<String> checkList = new ArrayList<>();
        checkList.addAll(storedMessages);
        // If we only check stored, we still get Message 2 (58 chars) vs Message 5 (28 chars) = correct
        for (String msg : checkList) {
            if (msg.length() > longest.length()) longest = msg;
        }
        return longest;
    }

    // 2c
    public String searchByMessageID(String searchID) {
        for (int i = 0; i < messageIDs.size(); i++) {
            if (messageIDs.get(i).equals(searchID)) {
                return "Recipient: " + recipients.get(i) + "\nMessage: " + allMessages.get(i);
            }
        }
        return "Message ID not found.";
    }

    public String searchByMessageID_Test(String searchID) {
        for (int i = 0; i < messageIDs.size(); i++) {
            if (messageIDs.get(i).equals(searchID)) {
                return recipients.get(i) + ", " + allMessages.get(i);
            }
        }
        return "";
    }

    // 2d
    public String searchByRecipient(String recipient) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < recipients.size(); i++) {
            if (recipients.get(i).equals(recipient)) {
                if (sb.length() > 0) sb.append("\n");
                sb.append(allMessages.get(i));
            }
        }
        if (sb.length() == 0) return "No messages found for this recipient.";
        return sb.toString();
    }

    // 2e
    public String deleteByHash(String hash) {
        for (int i = 0; i < messageHashes.size(); i++) {
            if (messageHashes.get(i).equals(hash)) {
                String msg = allMessages.get(i);
                storedMessages.remove(msg);
                messageHashes.remove(i);
                return "Message: \"" + msg + "\" successfully deleted.";
            }
        }
        return "Hash not found.";
    }

    // 2f
    public String displayReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== STORED MESSAGES REPORT ===\n");
        for (int i = 0; i < messageIDs.size(); i++) {
            sb.append("Message Hash: ").append(messageHashes.get(i)).append("\n");
            sb.append("Recipient: ").append(recipients.get(i)).append("\n");
            sb.append("Message: ").append(allMessages.get(i)).append("\n");
            sb.append("----------------------------\n");
        }
        return sb.toString();
    }

    public String getSentMessagesAsString() {
        return String.join(", ", sentMessages);
    }
}
