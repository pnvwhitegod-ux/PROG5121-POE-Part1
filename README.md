# PROG5121 POE - QuickChat - Part 3
**Student:** Vutshila Sambo  
**Module:** PROG5121 - Programming 1A  
**GitHub:** https://github.com/pnvwhitegod-ux/PROG5121-POE-Part1  

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
