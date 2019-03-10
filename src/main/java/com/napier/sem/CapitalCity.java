package com.napier.sem;

import java.util.ArrayList;
import java.sql.*;

public class CapitalCity {

    private String Name;
    private String Country;
    private int Population;
    private ArrayList<CapitalCity> listOfCapitalCities = new ArrayList<CapitalCity>();

    //Returns a list of all capital cities in the World/Continent/Region depending on parameter input
    public ArrayList<CapitalCity> getCapitalCities(String category, String name)
    {
        //Clear out any previous results
        listOfCapitalCities.clear();

        //To get all the capital cities in the world...
        if (category == "inWorld" && name == null)
        {
            try
            {
                // Create SQL statement
                Statement stmt = App.con.createStatement();

                // Create SQL Query as string
                String strQuery = "SELECT city.Name AS 'Capital City', "
                        + "country.Name AS 'Country', "
                        + "city.Population AS 'Population' "
                        + "FROM city JOIN country ON city.ID = country.Capital "
                        + "ORDER BY city.Population DESC";

                //Execute SQL statement
                ResultSet result = stmt.executeQuery(strQuery);

                //Iterate through results
                while (result.next())
                {
                    //Get information for each capital city/row in table
                    CapitalCity capCit = new CapitalCity();
                    capCit.Name = result.getString("Capital City");
                    capCit.Country = result.getString("Country");
                    capCit.Population = result.getInt("Population");

                    //Store each city to list
                    listOfCapitalCities.add(capCit);
                }

                //Check that capital cities were found
                if (listOfCapitalCities.isEmpty()) {
                    return null;
                }
                else
                {
                    //As long as cities were found, return the list of all cities
                    return listOfCapitalCities;
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to get details of all the capital cities in the world");
                return null;
            }
        }
        //To get all the capital cities in a particular continent...
        if (category == "inContinent" && name != null)
        {
            try
            {
                // Create SQL statement
                Statement stmt = App.con.createStatement();

                // Create SQL Query as string
                String strQuery = "SELECT city.Name AS 'Capital City', "
                        + "country.Name AS 'Country', "
                        + "city.Population AS 'Population' "
                        + "FROM city JOIN country ON city.ID = country.Capital "
                        + "WHERE country.Continent = '" + name + "' "
                        + "ORDER BY city.Population DESC";

                //Execute SQL statement
                ResultSet result = stmt.executeQuery(strQuery);

                //Iterate through results
                while (result.next())
                {
                    //Get information for each capital city/row in table
                    CapitalCity capCit = new CapitalCity();
                    capCit.Name = result.getString("Capital City");
                    capCit.Country = result.getString("Country");
                    capCit.Population = result.getInt("Population");

                    //Store each city to list
                    listOfCapitalCities.add(capCit);
                }

                //Check that capital cities were found
                if (listOfCapitalCities.isEmpty()) {
                    return null;
                }
                else
                {
                    //As long as cities were found, return the list of all cities
                    return listOfCapitalCities;
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to get details of all the capital cities in this continent");
                return null;
            }
        }
        //To get all the capital cities in a particular region...
        if (category == "inRegion" && name != null)
        {
            try
            {
                // Create SQL statement
                Statement stmt = App.con.createStatement();

                // Create SQL Query as string
                String strQuery = "SELECT city.Name AS 'Capital City', "
                        + "country.Name AS 'Country', "
                        + "city.Population AS 'Population' "
                        + "FROM city JOIN country ON city.ID = country.Capital "
                        + "WHERE country.Region = '" + name + "' "
                        + "ORDER BY city.Population DESC";

                //Execute SQL statement
                ResultSet result = stmt.executeQuery(strQuery);

                //Iterate through results
                while (result.next())
                {
                    //Get information for each capital city/row in table
                    CapitalCity capCit = new CapitalCity();
                    capCit.Name = result.getString("Capital City");
                    capCit.Country = result.getString("Country");
                    capCit.Population = result.getInt("Population");

                    //Store each city to list
                    listOfCapitalCities.add(capCit);
                }

                //Check that capital cities were found
                if (listOfCapitalCities.isEmpty()) {
                    return null;
                }
                else
                {
                    //As long as cities were found, return the list of all cities
                    return listOfCapitalCities;
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to get details of all the capital cities in this continent");
                return null;
            }
        }
        return null;
    }

    //Public getters to retrieve capital city information from other classes
    public String getName()
    {
        return Name;
    }
    public String getCountry()
    {
        return Country;
    }
    public Integer getPopulation()
    {
        return Population;
    }
}
