package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:3306");
    }

    @Test
    void testGetCountries()
    {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        //final PrintStream originalOut = System.out;

        DisplayResults displayResults = new DisplayResults();
        System.setOut(new PrintStream(outContent));
        displayResults.countriesInWorld();
        assertEquals("-----------------------------------------------------------------------------------------------------------------",
                outContent.toString());
    }
}