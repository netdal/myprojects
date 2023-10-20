package com.rijai.LocationApi.controller;

import com.rijai.LocationApi.model.Country;
import com.rijai.LocationApi.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class MyController {
    @Autowired
    private ICountryService countryService;


    @RequestMapping("/api/countries")
    public List<Country> findCountries(){
       return countryService.getCountries();
    }

    @RequestMapping(value = "/api/show-country/{id}")
    public Country showCountry(@PathVariable Long id) {
       return countryService.getCountry(id);
    }

    @RequestMapping(value="/api/add-country", method= RequestMethod.POST)
    public Country addCountrySubmit(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @RequestMapping(value="/api/update-country/{id}", method=RequestMethod.PUT)
    public Country updateCountry(@PathVariable Long id, @RequestBody Country country) {
        return countryService.updateCountry(id, country);
    }
    @RequestMapping(value = "/api/delete-country/{id}", method = {RequestMethod.DELETE, RequestMethod.POST})
    public String deleteCountry(@PathVariable("id") Long id) {
        countryService.deleteCountry(id);
        return "redirect:/countries";
    }

}
