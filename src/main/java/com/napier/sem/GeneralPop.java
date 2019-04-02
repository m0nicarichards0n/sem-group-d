package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GeneralPop {

    //Returns the population of the world
    public long getWorldPop()
    {
        try
        {
            //Local long to store result
            long pop = 0;

            // Create SQL statement
            Statement stmt = App.con.createStatement();

            // Create SQL Query as string
            String strQuery = "SELECT SUM(sub1.Population) AS 'World Population' "
                        + "FROM (SELECT country.Code AS 'Code', "
                        + "country.Name AS 'Country', "
                        + "country.Continent AS 'Continent', "
                        + "country.Region AS 'Region', "
                        + "country.Population AS 'Population', "
                        + "city.Name AS 'Capital' "
                        + "FROM country JOIN city ON country.Capital = city.ID "
                        + "ORDER BY population DESC) AS sub1";

            //Execute SQL statement
            ResultSet result = stmt.executeQuery(strQuery);

            while (result.next())
            {
                //Get world population value
                pop = result.getLong("World Population");
            }

            //Return world population value
            return pop;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to retrieve the population of the world");
            return 0;
        }
    }

    //Returns the population of a particular continent
    public long getContinentPop(String continent)
    {
        try
        {
            //Local long to store result
            long pop = 0;

            // Create SQL statement
            Statement stmt = App.con.createStatement();

            // Create SQL Query as string
            String strQuery = "SELECT SUM(sub1.Population) AS 'Total Population Of Continent' "
                        + "FROM (SELECT country.Code AS 'Code', "
                        + "country.Name AS 'Country', "
                        + "country.Continent AS 'Continent', "
                        + "country.Region AS 'Region', "
                        + "country.Population AS 'Population', "
                        + "city.Name AS 'Capital' "
                        + "FROM country JOIN city ON country.Capital = city.ID "
                        + "WHERE country.Continent = '" + continent + "' "
                        + "ORDER BY population DESC) AS sub1";

            //Execute SQL statement
            ResultSet result = stmt.executeQuery(strQuery);

            while (result.next())
            {
                //Get continent population value
                pop = result.getLong("Total Population Of Continent");
            }

            //Return continent population value
            return pop;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to retrieve the population of this continent");
            return 0;
        }
    }

    //Returns the population of a particular region
    public long getRegionPop(String region)
    {
        try
        {
            //Local long to store result
            long pop = 0;

            // Create SQL statement
            Statement stmt = App.con.createStatement();

            // Create SQL Query as string
            String strQuery = "SELECT SUM(sub1.Population) AS 'Total Population Of Region' "
                    + "FROM (SELECT country.Code AS 'Code', "
                    + "country.Name AS 'Country', "
                    + "country.Continent AS 'Continent', "
                    + "country.Region AS 'Region', "
                    + "country.Population AS 'Population', "
                    + "city.Name AS 'Capital' "
                    + "FROM country JOIN city ON country.Capital = city.ID "
                    + "WHERE country.Region = '" + region + "' "
                    + "ORDER BY country.Population DESC) AS sub1";

            //Execute SQL statement
            ResultSet result = stmt.executeQuery(strQuery);

            while (result.next())
            {
                //Get region population value
                pop = result.getLong("Total Population Of Region");
            }

            //Return region population value
            return pop;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to retrieve the population of this region");
            return 0;
        }
    }

    //Returns the population of a particular country
    public long getCountryPop(String country)
    {
        try
        {
            //Local long to store result
            long pop = 0;

            // Create SQL statement
            Statement stmt = App.con.createStatement();

            // Create SQL Query as string
            String strQuery = "SELECT country.Code AS 'Code', "
                        + "country.Name AS 'Country', "
                        + "country.Continent AS 'Continent', "
                        + "country.Region AS 'Region', "
                        + "country.Population AS 'Total Population Of Country', "
                        + "city.Name AS 'Capital' "
                        + "FROM country JOIN city ON country.Capital = city.ID "
                        + "WHERE country.Name = '" + country + "'";

            //Execute SQL statement
            ResultSet result = stmt.executeQuery(strQuery);

            while (result.next())
            {
                //Get country population value
                pop = result.getLong("Total Population Of Country");
            }

            //Return country population value
            return pop;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to retrieve the population of this country");
            return 0;
        }
    }

    //Returns the population of a particular district
    public long getDistrictPop(String district)
    {
        try
        {
            //Local long to store result
            long pop = 0;

            // Create SQL statement
            Statement stmt = App.con.createStatement();

            // Create SQL Query as string
            String strQuery = "SELECT SUM(city.Population) AS 'Total Population Of District' "
                    + "FROM city JOIN country ON city.CountryCode = country.Code "
                    + "WHERE city.District = '" + district + "'";

            //Execute SQL statement
            ResultSet result = stmt.executeQuery(strQuery);

            while (result.next())
            {
                //Get district population value
                pop = result.getLong("Total Population Of District");
            }

            //Return district population value
            return pop;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to retrieve the population of this district");
            return 0;
        }
    }

    //Returns the population of a particular city
    public long getCityPop(String city)
    {
        //Set up list to store population values
        ArrayList<Long> cityPopulations = new ArrayList<Long>();

        //Set up list to store country values
        ArrayList<String> cityCountries = new ArrayList<String>();

        try
        {
            //Local long to store result
            long pop = 0;

            // Create SQL statement
            Statement stmt = App.con.createStatement();

            // Create SQL Query as string
            String strQuery = "SELECT city.Name AS 'City', country.Name AS 'Country', city.District, city.Population "
                    + "FROM city JOIN country ON city.CountryCode = country.code "
                    + "WHERE city.Name = '" + city + "' "
                    + "ORDER BY population DESC";

            //Execute SQL statement
            ResultSet result = stmt.executeQuery(strQuery);

            //Count how many rows the query returns
            int count = 0;

            while (result.next()) {
                ++count;

                //Get population of each city returned
                Long population = result.getLong("Population");

                //Get the name of each country returned
                String country = result.getString("Country");

                //Store populations in list
                cityPopulations.add(population);

                //Store countries in list
                cityCountries.add(country);

                //Get city population value
                pop = population;
            }

            //If the query returns more than one city, ask which country the city is in
            if (count > 1)
            {
                //Run method to establish which country the city that the user wants to see the population of is in
                return getDuplicateCityPop(cityCountries, cityPopulations, city);
            }
            //If the query only returns one city
            if (count == 1)
            {
                //Return district population value
                return pop;
            }
            return pop;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to retrieve the population of this city");
            return 0;
        }
    }

    //Run this method if a user enters a city name which occurs in multiple countries
    //(e.g. London in Canada or the UK)
    public long getDuplicateCityPop(ArrayList<String> cityCountries, ArrayList<Long> cityPopulations, String city)
    {
        long pop = 0;
        int index = 0;
        System.out.println("View the population of " + city + " in:");
        //Iterate through countries returned
        for (String c : cityCountries)
        {
            ++index;
            //Display options to user
            System.out.println(index + ". " + c);
        }

        //Read user selection
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();

        //Return the population of the city in the country selected
        int populationToGet = Integer.parseInt(userInput) - 1;
        pop = cityPopulations.get(populationToGet);

        return pop;
    }
}
