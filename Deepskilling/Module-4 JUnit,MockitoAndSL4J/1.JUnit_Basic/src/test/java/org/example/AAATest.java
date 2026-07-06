package org.example;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AAATest {
    private Calculator cal;

    @Before
    public void setUp() {
        System.out.println("Setting up");
        cal = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning up");
        cal = null;
    }

    @Test
    public void testAddition() {

        int a = 20;
        int b = 10;

        int result = cal.add(a, b);

        assertEquals(30, result);
    }
}