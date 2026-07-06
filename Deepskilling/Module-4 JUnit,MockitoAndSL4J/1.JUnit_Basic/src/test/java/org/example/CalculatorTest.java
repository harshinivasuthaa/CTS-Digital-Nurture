package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator cal = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(15, cal.add(10, 5));
    }

    @Test
    public void testSubtract() {
        assertEquals(5, cal.subtract(10, 5));
    }

    @Test
    public void testMultiply() {
        assertEquals(50, cal.multiply(10, 5));
    }

    @Test
    public void testDivide() {
        assertEquals(2, cal.divide(10, 5));
    }
}