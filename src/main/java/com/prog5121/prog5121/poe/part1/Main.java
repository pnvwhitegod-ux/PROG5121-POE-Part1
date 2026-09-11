// Commit 5-Added registration Flow
package com.prog5121.prog5121.poe.part1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Registration ===");
        System.out.print("First Name: "); 
        String fn = sc.nextLine();
        System.out.print("Last Name: "); 
        String ln = sc.nextLine();
        System.out.print("Username (e.g v_sam): "); 
        String u = sc.nextLine();
        System.out.print("Password (e.g Vutshila079@): "); 
        String p = sc.nextLine();
        System.out.print("Cell (e.g +27795991780): "); 
        String c = sc.nextLine();
        
        Login login = new Login(fn, ln, u, p, c);
        
        System.out.println(login.getUsernameMessage(u));
        System.out.println(login.getPasswordMessage(p));
        System.out.println(login.getCellPhoneMessage(c));
        System.out.println(login.registerUser());
        
        if(login.registerUser().equals("User registered successfully.")){
            System.out.println("\n=== Login ===");
            System.out.print("Enter Username: "); 
            String lu = sc.nextLine();
            System.out.print("Enter Password: "); 
            String lp = sc.nextLine();
            System.out.println(login.returnLoginStatus(lu, lp));
        }
        sc.close();
    }
}
