# PROG5121 - POE Part 2 - QuickChat

**Student:** Vutshila Sambo  
**Module:** PROG5121 - Programming 1A  
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

### Unit Testing
- Right-click MessageTest.java -> Test File
- Result: Tests run: 5, Failures: 0, Errors: 0, Skipped: 0 - BUILD SUCCESS

### Technologies
- Java 21
- Maven
- JUnit 5.10.3 & JUnit 4.13.2
- NetBeans IDE

### GitHub
Project demonstrates Git best practices with regular commits and reuse of Part 1 code.
