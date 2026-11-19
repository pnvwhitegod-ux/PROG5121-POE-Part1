package com.prog5121.prog5121.poe.part1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

public class Message {
    private String messageID;
    private String recipient;
    private String messageText;
    private String messageHash;
    private static int messageCount = 0;

    public Message() {
        this.messageID = generateID();
        this.recipient = "";
        this.messageText = "";
        this.messageHash = "";
    }

    public Message(String recipient, String messageText) {
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageID = generateID();
        messageCount++;
        this.messageHash = createMessageHash(messageCount, messageText);
    }

    public Message(String id, String recipient, String messageText, int count) {
        this.messageID = id;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageHash = createMessageHash(count, messageText);
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setMessage(String messageText) {
        this.messageText = messageText;
    }

    public void setMessageID(String id) {
        this.messageID = id;
    }

    public void setMessageHash(String hash) {
        this.messageHash = hash;
    }

    private String generateID() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    public boolean checkRecipientCell(String recipient) {
        return recipient != null && recipient.length() <= 12 && recipient.startsWith("+27");
    }

    public boolean checkMessageLength() {
        return messageText != null && messageText.length() <= 250;
    }

    public String createMessageHash(int count, String message) {
        if (message == null || message.trim().isEmpty()) {
            return "00:0:EMPTY";
        }
        String[] words = message.trim().split("\\s+");
        String first = words[0].replaceAll("[^a-zA-Z]", "").toUpperCase();
        String last = words[words.length - 1].replaceAll("[^a-zA-Z]", "").toUpperCase();
        String idPart = (messageID != null && messageID.length() >= 2) ? messageID.substring(0, 2) : "00";
        return idPart + ":" + count + ":" + first + last;
    }

    public String createMessageHash() {
        return createMessageHash(messageCount, this.messageText);
    }

    public String sentMessage(String option) {
        if (option == null) {
            return "";
        }
        if (option.equalsIgnoreCase("Send")) {
            return "Message successfully sent.";
        } else if (option.equalsIgnoreCase("Disregard")) {
            return "Press 0 to delete message.";
        } else if (option.equalsIgnoreCase("Store")) {
            storeMessage();
            return "Message successfully stored.";
        }
        return "";
    }

    public void storeMessage() {
        try (FileWriter writer = new FileWriter("storedMessages.json", true)) {
            writer.write("{\"id\":\"" + messageID + "\",\"hash\":\"" + messageHash + "\",\"recipient\":\"" + recipient + "\",\"message\":\"" + (messageText != null ? messageText.replace("\"", "") : "") + "\"}\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error storing: " + e.getMessage());
        }
    }

    public String printMessages() {
        return "MessageID: " + messageID + "\nMessage Hash: " + messageHash + "\nRecipient: " + recipient + "\nMessage: " + messageText;
    }

    public String printMessage() {
        return printMessages();
    }

    public static int returnTotalMessages() {
        return messageCount;
    }

    public static void setMessageCount(int count) {
        messageCount = count;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessage() {
        return messageText;
    }

    public String getMessageHash() {
        return messageHash;
    }
}