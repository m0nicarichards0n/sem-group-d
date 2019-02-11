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
        String query =
                "SELECT * " +
                        "FROM country "+
                        "ORDER BY population DESC";
        query = a.selectQuery();
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
            while (rset.next())
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
                country.displayTable();
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries details");
        }
    }
}