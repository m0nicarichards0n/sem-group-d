package com.napier.sem;

import java.util.ArrayList;
import java.sql.*;

public class City {

    private String Name;
    private String Country;
    private String District;
    private int Population;
    private ArrayList<City> listOfCities = new ArrayList<City>();

    //Returns a list of all cities in the World/Continent/Region/Country/District depending on parameter input
    public ArrayList<City> getCities(String category, String name)
    {
        //Clear out any previous results
        listOfCities.clear();

        //To get all the cities in the world...
        if (category == "inWorld" && name == null)
        {
            try
            {
                // Create SQL statement
                Statement stmt = App.con.createStatement();

                // Create SQL Query as string
                String strQuery = "SELECT city.Name AS 'City', "
                        + "country.Name AS 'Country', "
                        + "city.District AS 'District', "
                        + "city.Population AS 'Population' "
                        + "FROM city INNER JOIN country ON city.countrycode = country.code "
                        + "ORDER BY population DESC";

                //Execute SQL statement
                ResultSet result = stmt.executeQuery(strQuery);

                //Iterate through results
                while (result.next())
                {
                    //Get information for each city/row in table
                    City cit = new City();
                    cit.Name = result.getString("City");
                    cit.Country = result.getString("Country");
                    cit.District = result.getString("District");
                    cit.Population = result.getInt("Population");

                    //Store each city to list
                    listOfCities.add(cit);
                }

                //Check that cities were found
                if (listOfCities.isEmpty()) {
                    return null;
                }
                else
                {
                    //As long as cities were found, return the list of all cities
                    return listOfCities;
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to get details of all the countries in the world");
                return null;
            }
        }
        //To get all the cities in a particular continent
        if (category == "inContinent" && name != null)
        {
            try
            {
                // Create SQL statement
                Statement stmt = App.con.createStatement();

                // Create SQL Query as string
                String strQuery = "SELECT city.Name AS 'City', "
                        + "country.Name AS 'Country', "
                        + "city.District AS 'District', "
                        + "city.Population AS 'Population' "
                        + "FROM city JOIN country ON city.CountryCode = country.Code "
                        + "WHERE country.Continent = '" + name + "' "
                        + "ORDER BY population DESC";

                //Execute SQL statement
                ResultSet result = stmt.executeQuery(strQuery);

                //Iterate through results
                while (result.next())
                {
                    //Get information for each city/row in table
                    City cit = new City();
                    cit.Name = result.getString("City");
                    cit.Country = result.getString("Country");
                    cit.District = result.getString("District");
                    cit.Population = result.getInt("Population");

                    //Store each city to list
                    listOfCities.add(cit);
                }

                //Check that cities were found
                if (listOfCities.isEmpty()) {
                    return null;
                }
                else
                {
                    //As long as cities were found, return the list of all cities
                    return listOfCities;
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

    //Public getters to retrieve city information from other classes
    public String getName()
    {
        return Name;
    }
    public String getCountry()
    {
        return Country;
    }
    public String getDistrict()
    {
        return District;
    }
    public Integer getPopulation()
    {
        return Population;
    }
}
