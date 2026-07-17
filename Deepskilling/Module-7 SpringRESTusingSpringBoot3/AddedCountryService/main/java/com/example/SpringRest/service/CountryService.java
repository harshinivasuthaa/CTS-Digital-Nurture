package com.example.SpringRest.service;

import com.example.SpringRest.Country;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    private static List<Country> countryList = new ArrayList<>();
    static {

        Country c1 = new Country();
        c1.setCode("IN");
        c1.setName("India");

        Country c2 = new Country();
        c2.setCode("US");
        c2.setName("United States");

        Country c3 = new Country();
        c3.setCode("JP");
        c3.setName("Japan");

        countryList.add(c1);
        countryList.add(c2);
        countryList.add(c3);
    }

    public Country getCountry(String code) {

        for (Country country : countryList) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }

        return null;
    }

}