package com.prog5121.prog5121.poe.part1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {
    @Test
    public void testIDLength() {
        Message m = new Message();
        m.checkMessageID();
        assertEquals(10, m.getMessageID().length());
    }
    @Test
    public void testRecipientValid() {
        Message m = new Message();
        assertEquals("Cell phone number successfully captured.", m.checkRecipientCell("+27821234567"));
    }
    @Test
    public void testRecipientInvalid() {
        Message m = new Message();
        assertTrue(m.checkRecipientCell("0821234567").contains("incorrectly formatted"));
    }
    @Test
    public void testLengthOK() {
        Message m = new Message();
        assertEquals("Message ready to send.", m.checkMessageLength("Hi tonight"));
    }
    @Test
    public void testHash() {
        Message m = new Message();
        assertEquals("00:0:HITONIGHT", m.createMessageHash("0011223344", 0, "Hi tonight"));
    }
    @Test
    public void testSent() {
        Message m = new Message();
        assertEquals("Message successfully sent.", m.sentMessage(1));
    }
}