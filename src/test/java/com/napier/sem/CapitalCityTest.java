package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CapitalCityTest {

    static CapitalCity capCity;

    @BeforeAll
    static void init()
    {
        capCity = new CapitalCity();
    }

    @Test
    public void wrong_params_returns_NULL(){
        String category = "wrong";
        String name = "params";

        assertEquals(null, capCity.getCapitalCities(category, name));
    }
    @Test
    public void params_inWorld_NULL(){
        String category = "inWorld";
        String name = null;

        assertEquals(null, capCity.getCapitalCities(category, name));
    }
}
