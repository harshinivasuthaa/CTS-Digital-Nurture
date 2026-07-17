package com.example.SpringDataJPA;

import com.example.SpringDataJPA.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("All Countries:");
        countryService.getAllCountries().forEach(System.out::println);

        System.out.println("\nCountry by Code:");
        System.out.println(countryService.getCountryByCode("IN"));

        System.out.println("\nCountry by Name:");
        System.out.println(countryService.getCountryByName("Japan"));

        System.out.println("\nCountries using HQL:");
        countryService.getAllCountriesHQL().forEach(System.out::println);
    }
}