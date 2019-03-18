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
            System.out.println("Failed to get details of all the countries in the world");
            return 0;
        }
    }

}
