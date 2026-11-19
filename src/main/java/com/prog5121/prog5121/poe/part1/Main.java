package com.prog5121.prog5121.poe.part1;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        MessageManager manager = new MessageManager();

        String first = JOptionPane.showInputDialog("Enter First Name:");
        String last = JOptionPane.showInputDialog("Enter Last Name:");
        String username = JOptionPane.showInputDialog("Enter Username (must contain _ and <=5 chars):");
        String password = JOptionPane.showInputDialog("Enter Password (8+ chars, capital, number, special):");
        String cell = JOptionPane.showInputDialog("Enter Cell (+27xxxxxxxxx):");

        String reg = login.registerUser(username, password, cell, first, last);
        JOptionPane.showMessageDialog(null, reg);
        if (!reg.equals("User registered successfully!")) return;

        String lu = JOptionPane.showInputDialog("Login - Enter Username:");
        String lp = JOptionPane.showInputDialog("Login - Enter Password:");
        JOptionPane.showMessageDialog(null, login.returnLoginStatus(lu, lp));
        if (!login.loginUser(lu, lp)) return;

        JOptionPane.showMessageDialog(null, "Welcome to QuickChat.");

        while (true) {
            String menu = JOptionPane.showInputDialog(null,
                "QuickChat Menu:\n\n" +
                "1) Send Messages\n" +
                "2) Show Recently Sent Messages\n" +
                "3) Stored Messages (Part 3)\n" +
                "4) Quit\n\nEnter choice:");
            if (menu == null || menu.equals("4")) {
                JOptionPane.showMessageDialog(null, "Total messages sent: " + Message.returnTotalMessages() + "\nGoodbye!");
                break;
            }
            switch (menu) {
                case "1":
                    String numStr = JOptionPane.showInputDialog("How many messages do you want to send?");
                    int num = Integer.parseInt(numStr);
                    for (int i = 0; i < num; i++) {
                        String recipient = JOptionPane.showInputDialog("Enter Recipient (+27... max 12 chars):");
                        String text = JOptionPane.showInputDialog("Enter Message (max 250 chars):");
                        if (text.length() > 250) {
                            JOptionPane.showMessageDialog(null, "Please enter a message of less than 250 characters.");
                            continue;
                        }
                        Message m = new Message(recipient, text);
                        if (!m.checkRecipientCell(recipient)) {
                            JOptionPane.showMessageDialog(null, "Cell phone number is incorrectly formatted or does not contain an international code, please correct the number and try again.");
                            continue;
                        }
                        String option = JOptionPane.showInputDialog("Choose:\nSend / Disregard / Store");
                        String result = m.sentMessage(option);
                        JOptionPane.showMessageDialog(null, result + "\n" + m.printMessages());
                        String flag = option.equalsIgnoreCase("Send") ? "Sent" : option.equalsIgnoreCase("Store") ? "Stored" : "Disregard";
                        manager.addMessage(m.getMessageID(), m.getRecipient(), first, m.getMessageText(), flag, m.getMessageHash());
                    }
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Sent Messages:\n" + manager.getSentMessagesAsString() + "\nTotal: " + Message.returnTotalMessages());
                    break;
                case "3":
                    if (manager.messageIDs.isEmpty()) {
                        manager.populateTestData();
                        JOptionPane.showMessageDialog(null, "Test data loaded for demo (5 messages from brief).");
                    }
                    String sub = JOptionPane.showInputDialog(null,
                        "Stored Messages:\n" +
                        "a) Display sender and recipient of all stored messages\n" +
                        "b) Display the longest stored message\n" +
                        "c) Search for message ID\n" +
                        "d) Search for messages for a particular recipient\n" +
                        "e) Delete a message using message hash\n" +
                        "f) Display a report\n\nEnter a, b, c, d, e or f:");
                    if (sub == null) break;
                    switch (sub.toLowerCase()) {
                        case "a": JOptionPane.showMessageDialog(null, manager.displaySenderAndRecipient()); break;
                        case "b": JOptionPane.showMessageDialog(null, "Longest Message:\n" + manager.displayLongestMessage()); break;
                        case "c":
                            String id = JOptionPane.showInputDialog("Enter Message ID (1-5 for test data):");
                            JOptionPane.showMessageDialog(null, manager.searchByMessageID(id)); break;
                        case "d":
                            String rec = JOptionPane.showInputDialog("Enter Recipient (e.g. +27838884567):");
                            JOptionPane.showMessageDialog(null, manager.searchByRecipient(rec)); break;
                        case "e":
                            String hash = JOptionPane.showInputDialog("Enter Message Hash (e.g. 00:2:WHERETIME):");
                            JOptionPane.showMessageDialog(null, manager.deleteByHash(hash)); break;
                        case "f": JOptionPane.showMessageDialog(null, manager.displayReport()); break;
                        default: JOptionPane.showMessageDialog(null, "Invalid option."); break;
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option.");
                    break;
            }
        }
    }
}