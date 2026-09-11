// Commit 2 - Added username validation logic
// Commit 3 - Added password complexity validation
package com.prog5121.prog5121.poe.part1;

import java.util.regex.Pattern;

public class Login {
    String firstName, lastName, username, password, cellPhone;

    public Login(String firstName, String lastName, String username, String password, String cellPhone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;
    }

    public boolean checkUserName(String username){
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password){
        return password.length() >= 8 
            && Pattern.compile("[A-Z]").matcher(password).find() 
            && Pattern.compile("[0-9]").matcher(password).find() 
            && Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]").matcher(password).find();
    }

    public boolean checkCellPhoneNumber(String cellPhone){
        return cellPhone.matches("^\\+27\\d{9}$");
    }

    public String registerUser(){
        if(!checkUserName(username)){
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if(!checkPasswordComplexity(password)){
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if(!checkCellPhoneNumber(cellPhone)){
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        return "User registered successfully.";
    }

    public boolean loginUser(String enteredUsername, String enteredPassword){
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    public String returnLoginStatus(String enteredUsername, String enteredPassword){
        if(loginUser(enteredUsername, enteredPassword)){
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    public String getUsernameMessage(String u){
        if(checkUserName(u)) return "Username successfully captured.";
        else return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
    }

    public String getPasswordMessage(String p){
        if(checkPasswordComplexity(p)) return "Password successfully captured.";
        else return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
    }

    public String getCellPhoneMessage(String c){
        if(checkCellPhoneNumber(c)) return "Cell phone number successfully added.";
        else return "Cell phone number incorrectly formatted or does not contain international code.";
    }
}
