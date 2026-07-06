package org.example.SpringTesting.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {
    CalculatorService service = new CalculatorService();
    @Test
    void testAdd() {
        assertEquals(15, service.add(10, 5));
    }
}