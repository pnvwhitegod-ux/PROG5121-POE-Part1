package com.prog5121.prog5121.poe.part1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessagePart3Test {
    @Test
    public void testSentMessagesArrayCorrectlyPopulated() {
        MessageManager m = new MessageManager();
        m.populateTestData();
        assertEquals("Did you get the cake?, It is dinner time !", m.getSentMessagesAsString());
    }
    @Test
    public void testDisplayLongestMessage() {
        MessageManager m = new MessageManager();
        m.populateTestData();
        assertEquals("Where are you? You are late! I have asked you to be on time.", m.displayLongestMessage());
    }
    @Test
    public void testSearchForMessageID() {
        MessageManager m = new MessageManager();
        m.populateTestData();
        assertEquals("0838884567, It is dinner time !", m.searchByMessageID_Test("4"));
    }
    @Test
    public void testSearchByRecipient() {
        MessageManager m = new MessageManager();
        m.populateTestData();
        String expected = "Where are you? You are late! I have asked you to be on time.\nOk, I am leaving without you.";
        assertEquals(expected, m.searchByRecipient("+27838884567"));
    }
    @Test
    public void testDeleteByHash() {
        MessageManager m = new MessageManager();
        m.populateTestData();
        assertEquals("Message: \"Where are you? You are late! I have asked you to be on time.\" successfully deleted.", m.deleteByHash("00:2:WHERETIME"));
    }
    @Test
    public void testDisplayReport() {
        MessageManager m = new MessageManager();
        m.populateTestData();
        String report = m.displayReport();
        assertTrue(report.contains("Message Hash"));
        assertTrue(report.contains("Recipient"));
        assertTrue(report.contains("Message"));
        assertTrue(report.contains("Did you get the cake?"));
    }
}