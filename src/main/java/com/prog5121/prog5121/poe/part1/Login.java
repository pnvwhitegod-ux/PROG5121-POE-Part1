// Commit 4 - Validation logics
package com.prog5121.prog5121.poe.part1;

public class Login {
    private String username;
    private String password;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }
    public boolean checkPasswordComplexity(String password) {
        boolean hasCap = !password.equals(password.toLowerCase());
        boolean hasNum = password.matches(".*\\d.*");
        boolean hasSpecial = !password.matches("[A-Za-z0-9 ]*");
        return password.length() >= 8 && hasCap && hasNum && hasSpecial;
    }
    public boolean checkCellPhoneNumber(String cell) {
        return cell.matches("^\\+27\\d{9}$");
    }
    public String registerUser(String user, String pass, String cell) {
        if (!checkUserName(user)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity(pass)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        if (!checkCellPhoneNumber(cell)) {
            return "Cell phone number is incorrectly formatted or does not contain an international code.";
        }
        this.username = user;
        this.password = pass;
        return "User registered successfully.";
    }
    public boolean loginUser(String user, String pass) {
        return user.equals(username) && pass.equals(password);
    }
    public String returnLoginStatus(boolean loggedIn) {
        return loggedIn ? "Welcome! It is great to see you again." : "Username or password incorrect, please try again.";
    }
}