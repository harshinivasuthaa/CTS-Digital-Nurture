package com.example.SpringRest.controller;

import com.example.SpringRest.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    @GetMapping("/country")
    public Country getCountry() {

        Country country = new Country();

        country.setCode("IN");
        country.setName("India");

        return country;
    }
}