package com.example.SpringDataJPA.repository;

import com.example.SpringDataJPA.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    Country findByCoCode(String coCode);

    Country findByCoName(String coName);

    @Query("SELECT c FROM Country c")
    List<Country> getAllCountriesHQL();
}