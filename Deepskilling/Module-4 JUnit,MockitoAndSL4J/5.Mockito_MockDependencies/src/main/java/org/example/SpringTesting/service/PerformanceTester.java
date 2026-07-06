package org.example.SpringTesting.service;

import org.springframework.stereotype.Service;

@Service
public class PerformanceTester {
    public void process(){
        for(int i=0;i<100000;i++);
    }
}