package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    public List<Country> getAllCountries() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        return (List<Country>) context.getBean("countryList");
    }

    public Country getCountry(String code) throws CountryNotFoundException {
        List<Country> countries = getAllCountries();
        for (Country c : countries) {
            if (c.getCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        throw new CountryNotFoundException("Country not found for code: " + code);
    }
}
