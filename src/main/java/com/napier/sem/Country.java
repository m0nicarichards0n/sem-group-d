package com.napier.sem;

import java.util.ArrayList;
import java.sql.*;

public class Country
{
    private String Code;
    private String Name;
    private String Continent;
    private String Region;
    private int Population;
    private String Capital;
    private ArrayList<Country> listOfCountries = new ArrayList<Country>();


    //Returns a list of all countries in the World/Continent/Region depending on parameter input
    public ArrayList<Country> getCountries(String category)
    {
        //To get all the countries in the world...
        if (category == "inWorld")
        {
            try
            {
                // Create SQL statement
                Statement stmt = App.con.createStatement();

                // Create SQL Query as string
                String strQuery = "SELECT country.Code AS 'Code', " +
                        "country.Name AS 'Country', " +
                        "country.Continent AS 'Continent', " +
                        "country.Region AS 'Region', " +
                        "country.Population AS 'Population', " +
                        "city.Name AS 'Capital' " +
                        "FROM country JOIN city ON country.Capital = city.ID " +
                        "ORDER BY population DESC";

                //Execute SQL statement
                ResultSet result = stmt.executeQuery(strQuery);

                //Iterate through results
                while (result.next())
                {
                    //Get information for each country/row in table
                    Country cou = new Country();
                    cou.Code = result.getString("Code");
                    cou.Name = result.getString("Country");
                    cou.Continent = result.getString("Continent");
                    cou.Region = result.getString("Region");
                    cou.Population = result.getInt("Population");
                    cou.Capital = result.getString("Capital");

                    //Store each country to list
                    listOfCountries.add(cou);
                }

                //Check that countries were found
                if (listOfCountries.isEmpty()) {
                    return null;
                }
                else
                {
                    //As long as countries were found, return the list of all countries
                    return listOfCountries;
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to get details of all the countries in the world");
                return null;
            }
        }
        return null;
    }

    //Public getters to retrieve information from other classes
    public String getCode()
    {
        return Code;
    }
    public String getName()
    {
        return Name;
    }
    public String getContinent()
    {
        return Continent;
    }
    public String getRegion()
    {
        return Region;
    }
    public Integer getPopulation()
    {
        return Population;
    }
    public String getCapital()
    {
        return Capital;
    }

}
