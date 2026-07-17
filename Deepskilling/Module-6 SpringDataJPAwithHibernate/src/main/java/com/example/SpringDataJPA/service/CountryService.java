package com.example.SpringDataJPA.service;

import com.example.SpringDataJPA.model.Country;
import com.example.SpringDataJPA.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
    public Country getCountryByCode(String code) {
        return countryRepository.findByCoCode(code);
    }

    public Country getCountryByName(String name) {
        return countryRepository.findByCoName(name);
    }

    public List<Country> getAllCountriesHQL() {
        return countryRepository.getAllCountriesHQL();
    }
}