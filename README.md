# PROG5121 - POE Part 2 - QuickChat

**Student:** Vutshila Sambo  
**Module:** PROG5121 - Programming 1A  
**YouTube Video (Unlisted): https://youtu.be/R2FXNQy1z_U**  
**GitHub:** https://github.com/pnvwhitegod-ux/PROG5121-POE-Part1  
**Project:** PROG5121-POE-Part1 (Reused for Part 2 as per IIE guidelines)

### Project Overview
This project reuses Part 1 Login/Registration system and extends it with Part 2 QuickChat messaging features.

### Features Implemented

**Part 1 Reused:**
- Username validation (must contain _ and <=5 chars, e.g kyl_1)
- Password complexity (8+ chars, capital, number, special char e.g Ch&&sec@ke99!)
- SA Cellphone validation (+27 + 9 digits e.g +27821234567)
- Registration and Login with status messages

**Part 2 New:**
- QuickChat Welcome Menu (1. Send Messages, 2. Show recently sent messages, 3. Quit)
- Message ID generation (10-digit random)
- Recipient cell validation
- Message length check (max 250 chars)
- Message Hash creation (e.g Hi tonight -> 00:0:HITONIGHT)
- Send / Disregard / Store options
- Array storage for sent messages
- JUnit 5 Unit Tests (5 tests, all passing)

### How to Run
1. Open project in NetBeans IDE 21
2. Right-click -> Clean and Build
3. Right-click Main.java -> Run File
4. Test Credentials:
   - Username: kyl_1
   - Password: Ch&&sec@ke99!
   - Cell: +27821234567
   - Recipient: +27831234567
   - Message: Hi tonight (to test hash)

### Screenshots

**1. Registration Successful**
![Screenshot 48](https://github.com/user-attachments/assets/fb69e440-4372-43ee-8080-0aa3bac37622)

**2. Welcome to QuickChat Menu**
![Screenshot 49](https://github.com/user-attachments/assets/1b99ac44-5d8c-4980-b5e7-e91d01194689)

**3. Message Sent with ID & Hash**
![Screenshot 50](https://github.com/user-attachments/assets/8823dc14-e724-42f4-a1f6-807b1fefd3fa)

**4. QuickChat Running**
![Screenshot 51](https://github.com/user-attachments/assets/d60dcb2a-0df3-461a-924c-acb7a873e1c0)

**5. Unit Tests**
![Screenshot 52](https://github.com/user-attachments/assets/7ca99950-1e3d-4969-95f9-cea3d75f7075)

### Unit Testing
- Right-click MessageTest.java -> Test File
- Result: Tests run: 5, Failures: 0, Errors: 0, Skipped: 0 - BUILD SUCCESS

### Technologies
- Java 21
- Maven
- JUnit 5.10.3 & JUnit 4.13.2
- NetBeans IDE

### GitHub Best Practices
Project demonstrates Git best practices with 6 regular commits and reuse of Part 1 code.
