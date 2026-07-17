package com.example.SpringRest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringRestApplication.class);

    public static void main(String[] args) {

        LOGGER.info("START");

        SpringApplication.run(SpringRestApplication.class, args);

        LOGGER.info("END");
    }
}
