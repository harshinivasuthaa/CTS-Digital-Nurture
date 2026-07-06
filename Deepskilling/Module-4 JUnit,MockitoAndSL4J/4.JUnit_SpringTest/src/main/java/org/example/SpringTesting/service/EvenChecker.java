package org.example.SpringTesting.service;

import org.springframework.stereotype.Service;

@Service
public class EvenChecker {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}