package com.napier.sem;

import java.sql.*;

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
}
