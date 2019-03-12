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

//    @Test
//    void testGetCountries()
//    {
//        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        //final PrintStream originalOut = System.out;
//
//        DisplayResults displayResults = new DisplayResults();
//        System.setOut(new PrintStream(outContent));
//        displayResults.countriesInWorld();
//        assertEquals("-----------------------------------------------------------------------------------------------------------------\\r\\n",
//                outContent.toString());
//    }
    @Test
    void testCountry(){
        //should return list of countries sorted by population
        Country cou = new Country();
        List<Country> getCountryReturns = cou.getCountries("inWorld", null);
        assertEquals(getCountryReturns.get(0).getName(), "China");
    }
}