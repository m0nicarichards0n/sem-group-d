package com.napier.sem;

import java.sql.*;

public class App
{
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();
        // Get Employee
        Country emp = a.getCountry(255530);
        // Display results
        a.displayCountry(emp);

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public Country getCountry(int ID)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * "
                    + "FROM country "
                    + "WHERE Name = 'Poland'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            if (rset.next())
            {
                Country country = new Country();
                country.Name = rset.getString("Name");
                country.Continent = rset.getString("Continent");
                country.Region = rset.getString("Region");
                country.SurfaceArea = rset.getInt("SurfaceArea");
                country.IndepYear = rset.getInt("IndepYear");
                country.Population = rset.getInt("Population");
                country.LifeExpectancy = rset.getInt("LifeExpectancy");
                country.GNP = rset.getInt("GNP");
                country.GNPOld = rset.getInt("GNPOld");
                country.LocalName = rset.getString("LocalName");
                country.GovernmentForm = rset.getString("GovernmentForm");
                country.HeadOfState = rset.getString("HeadOfState");
                country.Capital = rset.getString("Capital");
                country.Code2 = rset.getString("Code2");
                return country;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get employee details");
            return null;
        }
    }

    public void displayCountry(Country country)
    {
        if (country != null)
        {
            System.out.println(
                    country.Code + " "
                    + country.Name + " "
                    + country.Continent + " "
                    + country.Region + " "
                    + country.SurfaceArea + " "
                    + country.IndepYear + " "
                    + country.Population + " "
                    + country.LifeExpectancy + " "
                    + country.GNP + " "
                    + country.GNPOld + " "
                    + country.LocalName + " "
                    + country.GovernmentForm + " "
                    + country.HeadOfState + " "
                    + country.Capital + " "
                    + country.Code2 + "\n");
        }
    }
}