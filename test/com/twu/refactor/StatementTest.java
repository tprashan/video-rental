package com.twu.refactor;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StatementTest {
    @Test
    public void testGetFooterSummary(){
        Statement statement = new Statement();
        String expected = "HelloAmount owed is 5.0\nYou earned 9 frequent renter points";
        String result = statement.getSummary(5.0,9,"Hello");
        assertEquals(expected,result);
    }
}
