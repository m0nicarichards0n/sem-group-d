package com.napier.sem;

import java.util.ArrayList;
import java.sql.*;

public class LivingInCities {

    private String Continent;
    private String Region;
    private String Country;
    private long Population;
    private long LivingInCities;
    private double PercentageInCities;
    private long NotInCities;
    private double PercentageNotInCities;
    private ArrayList<LivingInCities> listLivingInCities = new ArrayList<LivingInCities>();

    //Returns a list of all people living/not living in cities in all Continents/Regions/Countries depending on parameter input
    public ArrayList<LivingInCities> getLivingInCities(String category)
    {
        //Clear out any previous results
        listLivingInCities.clear();

        //To find how many people are living/not living in cities in each continent...
        if (category == "inContinents")
        {
            try
            {
                // Create SQL statement
                Statement stmt = App.con.createStatement();

                // Create SQL Query as string
                String strQuery = "SELECT sub1.Continent, SUM(sub1.Population) AS 'Total Population', sub2.Population AS 'Total Population Living In Cities', "
                        + "100 - ROUND(((SUM(sub1.Population) - sub2.Population)*100)/SUM(sub1.Population), 1) AS 'Population Living In Cities (%)', "
                        + "SUM(sub1.Population) - sub2.Population AS 'Total Population NOT Living In Cities', "
                        + "ROUND(((SUM(sub1.Population) - sub2.Population)*100)/SUM(sub1.Population), 1) AS 'Population NOT Living In Cities (%)' "
                        + "FROM "
                        + "(SELECT country.Continent AS 'Continent', SUM(country.Population) AS 'Population' "
                        + "FROM country "
                        + "GROUP BY country.Continent) AS sub1, "
                        + "(SELECT country.Continent AS 'Continent', SUM(city.Population) AS 'Population' "
                        + "FROM country JOIN city ON country.Code = city.CountryCode "
                        + "GROUP BY country.Continent) AS sub2 "
                        + "WHERE sub2.Continent = sub1.Continent "
                        + "GROUP BY sub1.Continent "
                        + "ORDER BY SUM(sub1.Population) DESC";

                //Execute SQL statement
                ResultSet result = stmt.executeQuery(strQuery);

                //Iterate through results
                while (result.next())
                {
                    //Get information for each continent/row in table
                    LivingInCities lic = new LivingInCities();
                    lic.Continent = result.getString("Continent");
                    lic.Population = result.getLong("Total Population");
                    lic.LivingInCities = result.getLong("Total Population Living In Cities");
                    lic.PercentageInCities = result.getDouble("Population Living In Cities (%)");
                    lic.NotInCities = result.getLong("Total Population NOT Living In Cities");
                    lic.PercentageNotInCities = result.getDouble("Population NOT Living In Cities (%)");

                    //Store each continent to list
                    listLivingInCities.add(lic);
                }

                //Check that continents were found
                if (listLivingInCities.isEmpty()) {
                    return null;
                }
                else
                {
                    //As long as continents were found, return the list of all continents
                    return listLivingInCities;
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to get details of all those living/not living in each continent");
                return null;
            }
        }
        //To find how many people are living/not living in cities in each region...
        if (category == "inRegions")
        {
            try
            {
                // Create SQL statement
                Statement stmt = App.con.createStatement();

                // Create SQL Query as string
                String strQuery = "SELECT sub1.Region, SUM(sub1.Population) AS 'Total Population', "
                        + "sub2.Population AS 'Total Population Living In Cities', "
                        + "100 - ROUND(((SUM(sub1.Population) - sub2.Population)*100)/SUM(sub1.Population), 1) AS 'Population Living In Cities (%)', "
                        + "SUM(sub1.Population) - sub2.Population AS 'Total Population NOT Living In Cities', "
                        + "ROUND(((SUM(sub1.Population) - sub2.Population)*100)/SUM(sub1.Population), 1) AS 'Population NOT Living In Cities (%)' "
                        + "FROM (SELECT country.Region AS 'Region', SUM(country.Population) AS 'Population' "
                        + "FROM country "
                        + "GROUP BY country.Region) AS sub1, "
                        + "(SELECT country.Region AS 'Region', SUM(city.Population) AS 'Population' "
                        + "FROM country JOIN city ON country.Code = city.CountryCode "
                        + "GROUP BY country.Region) AS sub2 "
                        + "WHERE sub2.Region = sub1.Region "
                        + "GROUP BY sub1.Region "
                        + "ORDER BY SUM(sub1.Population) DESC";


                //Execute SQL statement
                ResultSet result = stmt.executeQuery(strQuery);

                //Iterate through results
                while (result.next())
                {
                    //Get information for each region/row in table
                    LivingInCities lic = new LivingInCities();
                    lic.Region = result.getString("Region");
                    lic.Population = result.getLong("Total Population");
                    lic.LivingInCities = result.getLong("Total Population Living In Cities");
                    lic.PercentageInCities = result.getDouble("Population Living In Cities (%)");
                    lic.NotInCities = result.getLong("Total Population NOT Living In Cities");
                    lic.PercentageNotInCities = result.getDouble("Population NOT Living In Cities (%)");

                    //Store each region to list
                    listLivingInCities.add(lic);
                }

                //Check that regions were found
                if (listLivingInCities.isEmpty()) {
                    return null;
                }
                else
                {
                    //As long as regions were found, return the list of all regions
                    return listLivingInCities;
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to get details of all those living/not living in each region");
                return null;
            }
        }
        //To find how many people are living/not living in cities in each country...
        if (category == "inCountries")
        {
            try
            {
                // Create SQL statement
                Statement stmt = App.con.createStatement();

                // Create SQL Query as string
                String strQuery = "SELECT sub1.Country, SUM(sub1.Population) AS 'Total Population', "
                            + "sub2.Population AS 'Total Population Living In Cities', "
                            + "100 - ROUND(((SUM(sub1.Population) - sub2.Population)*100)/SUM(sub1.Population), 1) AS 'Population Living In Cities (%)', "
                            + "SUM(sub1.Population) - sub2.Population AS 'Total Population NOT Living In Cities', "
                            + "ROUND(((SUM(sub1.Population) - sub2.Population)*100)/SUM(sub1.Population), 1) AS 'Population NOT Living In Cities (%)' "
                            + "FROM"
                            + "(SELECT country.Name AS 'Country', SUM(country.Population) AS 'Population' "
                            + "FROM country "
                            + "GROUP BY country.Name) AS sub1, "
                            + "(SELECT country.Name AS 'Country', SUM(city.Population) AS 'Population' "
                            + "FROM country JOIN city ON country.Code = city.CountryCode "
                            + "GROUP BY country.Name) AS sub2 "
                            + "WHERE sub2.Country = sub1.Country "
                            + "GROUP BY sub1.Country "
                            + "ORDER BY SUM(sub1.Population) DESC";


                //Execute SQL statement
                ResultSet result = stmt.executeQuery(strQuery);

                //Iterate through results
                while (result.next())
                {
                    //Get information for each country/row in table
                    LivingInCities lic = new LivingInCities();
                    lic.Country = result.getString("Country");
                    lic.Population = result.getLong("Total Population");
                    lic.LivingInCities = result.getLong("Total Population Living In Cities");
                    lic.PercentageInCities = result.getDouble("Population Living In Cities (%)");
                    lic.NotInCities = result.getLong("Total Population NOT Living In Cities");
                    lic.PercentageNotInCities = result.getDouble("Population NOT Living In Cities (%)");

                    //Store each country to list
                    listLivingInCities.add(lic);
                }

                //Check that countries were found
                if (listLivingInCities.isEmpty()) {
                    return null;
                }
                else
                {
                    //As long as countries were found, return the list of all countries
                    return listLivingInCities;
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to get details of all those living/not living in each country");
                return null;
            }
        }
        return null;
    }

    //Public getters to retrieve city information from other classes
    public String getContinent()
    {
        return Continent;
    }
    public String getRegion()
    {
        return Region;
    }
    public String getCountry()
    {
        return Country;
    }
    public long getPopulation()
    {
        return Population;
    }
    public long getLivingInCities()
    {
        return LivingInCities;
    }
    public double getPercentageInCities()
    {
        return PercentageInCities;
    }
    public long getNotInCities()
    {
        return NotInCities;
    }
    public double getPercentageNotInCities()
    {
        return PercentageNotInCities;
    }

}
