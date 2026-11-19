# PROG5121 POE - QuickChat - Part 3
**Student:** Vutshila Sambo  
**Module:** PROG5121 - Programming 1A  
**GitHub:** https://github.com/pnvwhitegod-ux/PROG5121-POE-Part1  
**YouTube Part 3:** https://youtu.be/R2FXNQy1z_U

## Overview
This project is the final part of the QuickChat POE. It extends Part 1 (Login & Registration) and Part 2 (Sending Messages) with array storage and a full Stored Messages report system.

## Part 1 - Login
- Username must contain `_` and be no more than 5 characters
- Password must be 8+ characters, with a capital letter, a number and a special character
- Cell number must be in international format `+27xxxxxxxxx`
- Login validates username and password and welcomes user by first + last name

## Part 2 - QuickChat
- Send messages (max 250 characters)
- Recipient must be `+27` and max 12 characters
- Message ID is a random 10-digit number
- Message Hash format: `First 2 digits of ID : Message Count : FIRSTWORDLASTWORD`
    - Example: `Hi tonight` -> `00:0:HITONIGHT`
- Options: Send / Disregard / Store
- Stored messages are saved to `storedMessages.json`

## Part 3 - Store Data and Display Task Report (NEW)

### Arrays Used
All arrays are populated from user input, not hard-coded in the main app:
- `sentMessages` - Messages sent
- `disregardedMessages` - Messages disregarded
- `storedMessages` - Messages stored
- `messageHashes` - Hash for each message
- `messageIDs` - ID for each message
- `recipients` - Recipient for each message

### Main Menu
1) Send Messages
2) Show Recently Sent Messages
3) Stored Messages (Part 3)
4) Quit

### Stored Messages Sub-Menu
a) Display sender and recipient of all stored messages
b) Display the longest stored message
c) Search for message ID
d) Search for messages for a particular recipient
e) Delete a message using message hash
f) Display a report

### Test Data (From Brief)
1. +27834557896 - Did you get the cake? - Sent
2. +27838884567 - Where are you? You are late! I have asked you to be on time. - Stored
3. +27834484567 - Yohoooo, I am at your gate. - Disregard
4. 0838884567 - It is dinner time ! - Sent
5. +27838884567 - Ok, I am leaving without you. - Stored

### Unit Tests - 6 Tests Passed
File: MessagePart3Test.java
1. Sent Messages array correctly populated -> Did you get the cake?, It is dinner time !
2. Display longest stored message -> Where are you? You are late! I have asked you to be on time.
3. Search for messageID 4 -> 0838884567, It is dinner time !
4. Search by recipient +27838884567 -> Message 2 + Message 5
5. Delete by hash -> Message: "Where are you? You are late! I have asked you to be on time." successfully deleted.
6. Display report -> Shows Message Hash, Recipient, Message for all messages

Test Result: Tests run: 6, Failures: 0, Errors: 0, BUILD SUCCESS

## How to Run
1. Open project in NetBeans
2. Run Main.java
3. Register -> Login -> QuickChat Menu
4. Choose 1 to send messages, 3 for Stored Messages
5. To run tests: Right-click MessagePart3Test.java > Test File

## Files
- Login.java - Part 1 Login
- Message.java - Part 2 Message logic
- MessageManager.java - Part 3 Arrays + Report logic
- Main.java - Main menu + Part 3 Stored Messages menu
- MessagePart3Test.java - Part 3 Unit Tests
- pom.xml - Maven + JUnit 5.10.3

## Screenshots
- App running showing Main Menu with option 3
- Stored Messages sub-menu a-f
- Longest message result
- Search by ID result
- Delete by hash result
- Report result
- JUnit: 6 tests passed BUILD SUCCESS
