package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.security.PrivilegedActionException;

import static org.junit.jupiter.api.Assertions.*;

public class CityTest {

    static City city;

    @BeforeAll
    static void init() throws PrivilegedActionException
    {
        city = new City();

//        Class<?> testedClass  = city.getClass();
//        Field[] fields = testedClass.getDeclaredFields();
//        AccessController.doPrivileged(new PrivilegedExceptionAction() {
//            public Object run() throws Exception {
//                for (Field field : fields) {
//                    field.setAccessible(true);
//                    if(field.getName()=="Name"){
//                        field.set(city, "some name");
//                    }
//                    if(field.getName()=="Country"){
//                        field.set(city, "some Country");
//                    }
//                    if(field.getName()=="District"){
//                        field.set(city, "some District");
//                    }
//                    if(field.getName()=="Population"){
//                        field.set(city, 666);
//                    }
//                }
//                return null;
//            }
//        });
    }

    @Test
    public void wrong_params_returns_NULL(){
        String category = "wrong";
        String name = "params";

        assertEquals(null, city.getCities(category, name));
    }
    @Test
    public void params_inWorld_NULL(){
        String category = "inWorld";
        String name = null;
        assertEquals(null , city.getCities(category, name));
    }
    @Test
    public void params_inContinent_NULL(){
        String category = "inContinent";
        String name = null;
        assertEquals(null , city.getCities(category, name));
    }
    @Test
    public void params_inRegion_NULL(){
        String category = "inRegion";
        String name = null;
        assertEquals(null , city.getCities(category, name));
    }
    @Test
    public void params_inCountry_NULL(){
        String category = "inCountry";
        String name = null;
        assertEquals(null , city.getCities(category, name));
    }
    @Test
    public void get_name(){
        assertEquals(null, city.getName());
    }
    @Test
    public void get_Country(){
        assertEquals(null, city.getCountry());
    }
    @Test
    public void get_District(){
        assertEquals(null, city.getDistrict());
    }
    @Test
    public void get_Population(){
        assertEquals(0, city.getPopulation());
    }
}
