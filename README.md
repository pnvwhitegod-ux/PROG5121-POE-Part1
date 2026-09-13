<img width="1366" height="768" alt="Screenshot (25)" src="https://github.com/user-attachments/assets/c35d14f9-27ee-4880-837a-4ebe09458d82" />
<img width="1366" height="768" alt="Screenshot (24)" src="https://github.com/user-attachments/assets/5f02f197-f373-4190-922d-f27e606c7758" />
# PROG5121 POE Part 1 - Registration and Login

## Overview
Java console application that handles user registration and login with strict validation rules for username, password, and South African cellphone number.

## GitHub
https://github.com/pnvwhitegod-ux/PROG5121-POE-Part1

## Validations Implemented

**Username:**
- Must contain an underscore (_)
- Must be no more than 5 characters long

**Password:**
- At least 8 characters long
- Contains a capital letter
- Contains a number
- Contains a special character

**Cellphone:**
- Must include South African international code +27
- Format: +27 followed by 9 digits
- Example: +27831234567
- Validated using Regex

## Files
- `Login.java` - All validation methods (checkUserName, checkPasswordComplexity, checkCellPhoneNumber, registerUser, loginUser, returnLoginStatus)
- `Main.java` - Main method, user input with Scanner, registration flow
- `pom.xml` - Maven project file

## How To Run
1. Open project in NetBeans
2. Run Main.java
3. Enter username, password, cellphone when prompted
4. System will show if registration is successful

## Commits History (6 Commits)
1. Initial project setup - POE PART 1 Registration and Login
2. Added username validation
3. Add username and password validation logic
4. Add validation for username, password, and cellphone
5. Add registration flow to Main class
6. Finalize registration flow in Main class

## Tools Used
- Java JDK 17
- Apache NetBeans
- Git & GitHub
- Maven

## Author
pnvwhitegod-ux - PROG5121 2026
