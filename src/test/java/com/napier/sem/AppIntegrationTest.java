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

    //Country class tests

    @Test
    void testCountry_wrongCategory_null(){
        //should return list of countries sorted by population
        Country cou = new Country();
        List<Country> getCountryReturns = cou.getCountries("!@#$%^&*()_+", null);
        assertNull(getCountryReturns);
    }
    @Test
    void testCountry_wrongCategory_notNull(){
        //should return list of countries sorted by population
        Country cou = new Country();
        List<Country> getCountryReturns = cou.getCountries("!@#$%^&*()_+", "!@#$%^&*()_+");
        assertNull(getCountryReturns);
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
    //CapitalCity class Tests
    @Test
    void testCapitalCity_wrongCategory_null(){
        //should return list of countries sorted by population
        CapitalCity capCit = new CapitalCity();
        List<CapitalCity> getCapitalCitiesReturns = capCit.getCapitalCities("!@#$%^&*()_+", null);
        assertNull(getCapitalCitiesReturns);
    }
    @Test
    void testCapitalCity_wrongCategory_notNull(){
        //should return list of countries sorted by population
        CapitalCity capCit = new CapitalCity();
        List<CapitalCity> getCapitalCitiesReturns = capCit.getCapitalCities("!@#$%^&*()_+", "!@#$%^&*()_+");
        assertNull(getCapitalCitiesReturns);
    }
    @Test
    void testCapitalCity_inWorld_null(){
        //should return list of countries sorted by population
        CapitalCity capCit = new CapitalCity();
        List<CapitalCity> getCapitalCitiesReturns = capCit.getCapitalCities("inWorld", null);
        assertEquals(getCapitalCitiesReturns.get(0).getName(), "Seoul");
    }
    @Test
    void testCapitalCity_inWorld_notNull(){
        //should return list of countries sorted by population
        CapitalCity capCit = new CapitalCity();
        List<CapitalCity> getCapitalCitiesReturns = capCit.getCapitalCities("inWorld", "!@#$%^&*()_+");
        assertNull(getCapitalCitiesReturns);
    }
    @Test
    void testCapitalCity_inContinent_null(){
        //should return list of countries sorted by population
        CapitalCity capCit = new CapitalCity();
        List<CapitalCity> getCapitalCitiesReturns = capCit.getCapitalCities("inContinent", null);
        assertNull(getCapitalCitiesReturns);
    }
    @Test
    void testCapitalCity_inContinent_notNull(){
        //should return list of countries sorted by population
        CapitalCity capCit = new CapitalCity();
        List<CapitalCity> getCapitalCitiesReturns = capCit.getCapitalCities("inContinent", "!@#$%^&*()_+");
        assertNull(getCapitalCitiesReturns);
    }
    @Test
    void testCapitalCity_inContinent_correctName(){
        //should return list of countries sorted by population
        CapitalCity capCit = new CapitalCity();
        List<CapitalCity> getCapitalCitiesReturns = capCit.getCapitalCities("inContinent", "Europe");
        assertEquals(getCapitalCitiesReturns.get(0).getName(), "Moscow");
    }

    // City class tests
    @Test
    void testCity_wrongCategory_null(){
        //should return list of countries sorted by population
        City city = new City();
        List<City> getCitiesReturns = city.getCities("!@#$%^&*()_+", null);
        assertNull(getCitiesReturns);
    }
    @Test
    void testCity_wrongCategory_notNull(){
        //should return list of countries sorted by population
        City city = new City();
        List<City> getCitiesReturns = city.getCities("!@#$%^&*()_+", "!@#$%^&*()_+");
        assertNull(getCitiesReturns);
    }
    @Test
    void testCity_inWorld_null(){
        //should return list of countries sorted by population
        City city = new City();
        List<City> getCitiesReturns = city.getCities("inWorld", null);
        assertEquals(getCitiesReturns.get(0).getName(), "Mumbai (Bombay)");
    }
    @Test
    void testCity_inWorld_notNull(){
        //should return list of countries sorted by population
        City city = new City();
        List<City> getCitiesReturns = city.getCities("inWorld", "!@#$%^&*()_+");
        assertNull(getCitiesReturns);
    }
    @Test
    void testCity_inContinent_null(){
        //should return list of countries sorted by population
        City city = new City();
        List<City> getCitiesReturns = city.getCities("inContinent", null);
        assertNull(getCitiesReturns);
    }
    @Test
    void testCity_inContinent_wrongName(){
        //should return list of countries sorted by population
        City city = new City();
        List<City> getCitiesReturns = city.getCities("inContinent", "!@#$%^&*()_+");
        assertNull(getCitiesReturns);
    }
    @Test
    void testCity_inContinent_correctName(){
        //should return list of countries sorted by population
        City city = new City();
        List<City> getCitiesReturns = city.getCities("inContinent", "Europe");
        assertEquals(getCitiesReturns.get(0).getName(), "Moscow");
    }
    // LivingInCities class Tests
    @Test
    void testLivingInCities_null(){
        //should return list of countries sorted by population
        LivingInCities liveInCities = new LivingInCities();
        List<LivingInCities> getLivingInCitiesReturns = liveInCities.getLivingInCities(null);
        assertNull(getLivingInCitiesReturns);
    }
    @Test
    void testLivingInCities_inCorrect_Category(){
        //should return list of countries sorted by population
        LivingInCities liveInCities = new LivingInCities();
        List<LivingInCities> getLivingInCitiesReturns = liveInCities.getLivingInCities("!@#$%^&*()_+");
        assertNull(getLivingInCitiesReturns);
    }
    @Test
    void testLivingInCities_correctCategory(){
        //should return list of countries sorted by population
        LivingInCities liveInCities = new LivingInCities();
        List<LivingInCities> getLivingInCitiesReturns = liveInCities.getLivingInCities("inContinents");
        assertEquals(getLivingInCitiesReturns.get(0).getPopulation(), 3705025700L);
    }

}