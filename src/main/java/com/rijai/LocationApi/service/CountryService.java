package com.rijai.LocationApi.service;

import com.rijai.LocationApi.model.Country;
import com.rijai.LocationApi.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService implements ICountryService {
    @Autowired
    private CountryRepository repository;

    public List<Country> getCountries() {
        return (List<Country>) repository.findAll();
    }

    public Country getCountry(Long id) {
        Optional optional=repository.findById(id);
        if(optional.isEmpty())
            return null;
        else
            return (Country) optional.get();
    }

    public Country addCountry(Country country) {
        return repository.save(country);
    }

    public Country updateCountry(Long id, Country country) {
        Optional<Country> existingCountry = repository.findById(id);
        if(existingCountry.isPresent()) {
            return repository.save(country);
        }
        else
            return null;
    }

    public void deleteUser(Long id)
    {
        Optional<Country> country = repository.findById(id);
        if(country.isPresent()) {
            repository.delete(country.get());
        }
    }

    public void deleteCountry(Long id) {
        Optional<Country> country = repository.findById(id);
        country.ifPresent(value -> repository.delete(value));
    }

    public Country findById(Long id) {
        Optional<Country> country = repository.findById(id);
        return country.orElse(null);
    }




}
