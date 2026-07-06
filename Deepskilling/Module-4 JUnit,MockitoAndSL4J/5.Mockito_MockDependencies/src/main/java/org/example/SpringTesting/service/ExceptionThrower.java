package org.example.SpringTesting.service;

import org.springframework.stereotype.Service;

@Service
public class ExceptionThrower {
    public void divide(int a,int b){
        if(b==0)
            throw new ArithmeticException("Cannot divide by zero");
        System.out.println(a/b);
    }
}