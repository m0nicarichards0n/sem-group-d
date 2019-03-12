package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test
    void testCountry_inWorld_null(){
        //should return list of countries sorted by population
        Country cou = new Country();
        List<Country> getCountryReturns = cou.getCountries("inWorld", null);
        assertEquals(getCountryReturns.get(0).getName(), "China");
    }
    @Test
    void testCountry_inWorld_notNull(){
        //should return null, when wrong name passed in
        Country cou = new Country();
        List<Country> getCountryReturns = cou.getCountries("inWorld", "!@#$%^&*()_+");
        assertNull(getCountryReturns);
    }

    @Test
    void testCountry_inContinent_null(){
        //should return null if wrong passed null==null
        Country cou = new Country();
        List<Country> getCountryReturns = cou.getCountries("inContinent", null);
        assertNull(getCountryReturns);
    }
    @Test
    void testCountry_inContinent_notNull_butWrongName(){
        //should return null, when wrong name passed in
        Country cou = new Country();
        List<Country> getCountryReturns = cou.getCountries("inContinent", "!@#$%^&*()_+");
        assertNull(getCountryReturns);
    }

    @Test
    void testCountry_inContinent_NotNull_correctName(){
        //should return null, when wrong name passed in
        Country cou = new Country();
        List<Country> getCountryReturns = cou.getCountries("inContinent", "europe");
        assertEquals(getCountryReturns.get(0).getName(), "Russian Federation");
    }


    @Test
    void testCountry_inRegion_null(){
        //should return null if wrong passed null==null
        Country cou = new Country();
        List<Country> getCountryReturns = cou.getCountries("inRegion", null);
        assertNull(getCountryReturns);
    }
    @Test
    void testCountry_inRegion_notNull_butWrongName(){
        //should return null, when wrong name passed in
        Country cou = new Country();
        List<Country> getCountryReturns = cou.getCountries("inRegion", "!@#$%^&*()_+");
        assertNull(getCountryReturns);
    }

    @Test
    void testCountry_inRegion_NotNull_correctName(){
        //should return null, when wrong name passed in
        Country cou = new Country();
        List<Country> getCountryReturns = cou.getCountries("inRegion", "Southern Europe");
        assertEquals(getCountryReturns.get(0).getName(), "Italy");
    }
}