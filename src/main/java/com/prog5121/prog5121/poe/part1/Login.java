package com.prog5121.prog5121.poe.part1;

public class Login {
    private String username;
    private String password;
    private String cellphone;
    private String firstName;
    private String lastName;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        boolean hasCapital = !password.equals(password.toLowerCase());
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");
        return password.length() >= 8 && hasCapital && hasNumber && hasSpecial;
    }

    public boolean checkCellPhoneNumber(String cell) {
        return cell.matches("^\\+27\\d{9}$");
    }

    public String registerUser(String username, String password, String cell, String first, String last) {
        this.username = username;
        this.password = password;
        this.cellphone = cell;
        this.firstName = first;
        this.lastName = last;
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        if (!checkCellPhoneNumber(cell)) {
            return "Cell phone number is incorrectly formatted or does not contain an international code, please correct the number and try again.";
        }
        return "User registered successfully!";
    }

    public boolean loginUser(String username, String password) {
        return username.equals(this.username) && password.equals(this.password);
    }

    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    public String getFirstName() { return firstName; }
}