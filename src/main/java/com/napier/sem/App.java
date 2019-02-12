package com.napier.sem;

import java.sql.*;
import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();
        // Connect to database
        a.connect();
        // call sql query
        String query = a.selectQuery();
        a.getCountry(query);

        // Disconnect from database
        a.disconnect();
    }
    private String selectQuery(){
        String query ="";
        System.out.println("Available reports: ");
        System.out.println("1. All the countries in the world organised by largest population to smallest.");
        System.out.println("2. All the countries in a continent organised by largest population to smallest");
        System.out.println("3. All the countries in a region organised by largest population to smallest.");
        System.out.println("4. The top N populated countries in the world where N is provided by the user.");
        System.out.println("5. The top N populated countries in a continent where N is provided by the user.");
        System.out.println("Please select report number: ");
        Scanner scanner = new Scanner(System.in);
        String reportNumber = scanner.next();

        String N;
        switch (reportNumber){
            case "1":
                query = "SELECT name FROM country ORDER BY population DESC";
                break;
            case "2":
                query = "SELECT name, continent, population FROM country ORDER BY continent, population DESC";
                break;
            case "3":
                query = "SELECT name, region, population FROM country ORDER BY region, population DESC";
                break;
            case "4":
                System.out.println("How many top populated countries in the world would you like to see? ");
                scanner = new Scanner(System.in);
                N = scanner.nextLine();
                System.out.println("SELECT name, population FROM country ORDER BY population DESC LIMIT " + N);
                query = "SELECT name, population FROM country ORDER BY population DESC LIMIT " + N;
                break;
            case "5":
                System.out.println("How many top populated countries in a continent would you like to see? ");
                scanner = new Scanner(System.in);
                N = scanner.nextLine();
                query = "SELECT name, population FROM country WHERE continent = Europe ORDER BY population DESC LIMIT " + N;
                break;
        }

        return query;
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
                Thread.sleep(10000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + i);
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
    public void getCountry(String query)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(query);
            // Check one is returned
            ResultSetMetaData rsmd = rset.getMetaData();
            while (rset.next())
            {
                Country country = new Country();
                try { country.Name = rset.getString("Name");} catch (Exception e){country.Name = null;};
                try { country.Continent = rset.getString("Continent");} catch (Exception e){country.Continent = null;};
                try { country.Region = rset.getString("Region");} catch (Exception e){country.Region = null;};
                try { country.SurfaceArea = rset.getInt("SurfaceArea");} catch (Exception e){country.SurfaceArea = 0.0;};
                try { country.IndepYear = rset.getInt("IndepYear");} catch (Exception e){country.IndepYear = 0000;};
                try { country.Population = rset.getInt("Population");} catch (Exception e){country.Population = 0;};
                try { country.LifeExpectancy = rset.getInt("LifeExpectancy");} catch (Exception e){country.LifeExpectancy = 0.0;};
                try { country.GNP = rset.getInt("GNP");} catch (Exception e){country.GNP = 0.0;};
                try { country.GNPOld = rset.getInt("GNPOld");} catch (Exception e){country.GNPOld = 0.0;};
                try { country.LocalName = rset.getString("LocalName");} catch (Exception e){country.LocalName = null;};
                try { country.GovernmentForm = rset.getString("GovernmentForm");} catch (Exception e){country.GovernmentForm = null;};
                try { country.HeadOfState = rset.getString("HeadOfState");} catch (Exception e){country.HeadOfState = null;};
                try { country.Capital = rset.getString("Capital");} catch (Exception e){country.Capital = null;};
                try { country.Code2 = rset.getString("Code2");} catch (Exception e){country.Code2 = null;};
                country.displayTable();
            }
            getCountry(selectQuery());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries details");
        }
    }
}