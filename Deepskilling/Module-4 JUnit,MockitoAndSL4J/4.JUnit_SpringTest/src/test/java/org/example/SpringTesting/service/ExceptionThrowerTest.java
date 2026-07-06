package org.example.SpringTesting.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest{
    ExceptionThrower obj = new ExceptionThrower();

    @Test
    void testException(){
        assertThrows(ArithmeticException.class, () -> obj.divide(10,0));
    }
}