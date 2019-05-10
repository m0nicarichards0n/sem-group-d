//package com.napier.sem;
//
//
//}
package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LivingInCitiesTest {

    static LivingInCities livingInCities;

    @BeforeAll
    static void init()
    {
        livingInCities = new LivingInCities();
    }

    @Test
    public void wrong_params_returns_NULL(){
        String category = "wrong";

        assertEquals(null, livingInCities.getLivingInCities(category));
    }
    @Test
    public void inContinents_null(){
        String category = "inContinents";

        assertEquals(null, livingInCities.getLivingInCities(category));
    }
    @Test
    public void inRegions_null(){
        String category = "inRegions";

        assertEquals(null, livingInCities.getLivingInCities(category));
    }
    @Test
    public void inCountries_null(){
        String category = "inCountries";

        assertEquals(null, livingInCities.getLivingInCities(category));
    }
    @Test
    public void getCountry_return_null(){
        assertEquals(null, livingInCities.getCountry());
    }
    @Test
    public void getLivingInCities_return_null(){
        assertEquals(0, livingInCities.getLivingInCities());
    }
    @Test
    public void getContinent_return_null(){
        assertEquals(null, livingInCities.getContinent());
    }
    @Test
    public void getRegion_return_null(){
        assertEquals(null, livingInCities.getRegion());
    }
    @Test
    public void getPopulation_return_null(){
        assertEquals(0, livingInCities.getPopulation());
    }
    @Test
    public void getPercentageInCities_return_null(){
        assertEquals(0, livingInCities.getPercentageInCities());
    }
    @Test
    public void getNotInCities_return_null(){
        assertEquals(0, livingInCities.getNotInCities());
    }
    @Test
    public void getPercentageNotInCities_return_null(){
        assertEquals(0, livingInCities.getPercentageNotInCities());
    }
}