// Commit 3 - Console flow logic explaineds
package com.prog5121.prog5121.poe.part1;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Login login = new Login();
        
        System.out.println("=== Registration ===");
        System.out.print("Username (e.g kly_1): ");
        String user = sc.nextLine();
        System.out.print("Password (e.g Ch&&sec@ke99!): ");
        String pass = sc.nextLine();
        System.out.print("Cell (+27...): ");
        String cell = sc.nextLine();
        
        String reg = login.registerUser(user, pass, cell);
        System.out.println(reg);
        if (!reg.equals("User registered successfully.")) return;
        
        System.out.println("\n=== Login ===");
        System.out.print("Username: ");
        String lu = sc.nextLine();
        System.out.print("Password: ");
        String lp = sc.nextLine();
        
        boolean logged = login.loginUser(lu, lp);
        System.out.println(login.returnLoginStatus(logged));
        if (!logged) return;
        
        System.out.println("\nWelcome to QuickChat.");
        System.out.print("How many messages to send? ");
        int total = Integer.parseInt(sc.nextLine());
        
        ArrayList<String> sentList = new ArrayList<String>();
        int count = 0;
        
        while (true) {
            System.out.println("\n1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choose: ");
            String opt = sc.nextLine();
            
            if (opt.equals("1")) {
                if (count >= total) {
                    System.out.println("No more messages to send.");
                    continue;
                }
                Message m = new Message();
                System.out.print("Recipient (+27...): ");
                String rec = sc.nextLine();
                System.out.println(m.checkRecipientCell(rec));
                
                System.out.print("Message (try Hi tonight): ");
                String txt = sc.nextLine();
                System.out.println(m.checkMessageLength(txt));
                
                m.checkMessageID();
                System.out.println("ID: " + m.getMessageID());
                System.out.println("Hash: " + m.createMessageHash(m.getMessageID(), count, txt));
                
                System.out.println("1 Send 2 Disregard 3 Store");
                int ch = Integer.parseInt(sc.nextLine());
                System.out.println(m.sentMessage(ch));
                
                if (ch == 1) {
                    sentList.add(txt);
                    count++;
                }
            } else if (opt.equals("2")) {
                System.out.println("--- Sent Messages ---");
                if (sentList.isEmpty()) System.out.println("None");
                else {
                    for (int i=0;i<sentList.size();i++) {
                        System.out.println((i+1)+". "+sentList.get(i));
                    }
                }
            } else if (opt.equals("3")) {
                System.out.println("Total sent: " + count);
                System.out.println("Goodbye!");
                break;
            }
        }
        sc.close();
    }
}