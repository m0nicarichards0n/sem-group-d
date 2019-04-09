package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CountryTest {

    static Country country;

    @BeforeAll
    static void init()
    {
        country = new Country();
    }

    @Test
    public void wrong_params_returns_NULL(){
        String category = "wrong";
        String name = "params";

        assertEquals(null, country.getCountries(category, name));
    }
    @Test
    public void inWorld_null(){
        String category = "inWorld";
        String name = null;

        assertEquals(null, country.getCountries(category, name));
    }
    @Test
    public void inContinent_null(){
        String category = "inContinent";
        String name = null;

        assertEquals(null, country.getCountries(category, name));
    }
    @Test
    public void inRegion_null(){
        String category = "inRegion";
        String name = null;

        assertEquals(null, country.getCountries(category, name));
    }
    @Test
    public void getCode_return_null(){
        assertEquals(null, country.getCode());
    }
    @Test
    public void getName_return_null(){
        assertEquals(null, country.getName());
    }
    @Test
    public void getContinent_return_null(){
        assertEquals(null, country.getContinent());
    }
    @Test
    public void getRegion_return_null(){
        assertEquals(null, country.getRegion());
    }
    @Test
    public void getPopulation_return_null(){
        assertEquals(0, country.getPopulation());
    }
    @Test
    public void getCapital_return_null(){
        assertEquals(null, country.getCapital());
    }
}
