package com.napier.sem;

import java.sql.*;
import java.util.Scanner;

public class App
{
    public static void main(String[] args) {
        // Create new Application
        App a = new App();
        //Instantiate new set of results
        DisplayResults displayResults = new DisplayResults();
        // Connect to database
        a.connect();

        //Display main menu
        a.mainMenu();

        // Disconnect from database
        //a.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    public static Connection con = null;

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

    public String mainMenu() {
        boolean validInput;
        do {
            validInput = true;
            //Display main menu options
            System.out.println("Welcome to the Population Database!");
            System.out.println("I would like to view...");
            System.out.println("1. All the countries in...");
            System.out.println("2. All the cities in...");
            System.out.println("3. All the capital cities in...");
            System.out.println("4. The population of...");

            //Read user input
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.next();
            scanner.close();

            //If user input is valid, return user input
            if (userInput == "1")
            {
                return userInput;
            }
            //If user input is invalid, throw error message and ask again
            else if (userInput == "2" || userInput == "3"
                    || userInput == "4")
            {
                validInput = false;
                System.out.println("ERROR: Option currently unavailable");
            }
            else
            {
                System.out.println("ERROR: Invalid option selected");
                validInput = false;
            }
        } while (validInput == false);
        return null;
    }

    /*
    public boolean secondMenu()
    {
        //If user input is valid, display next set of options depending on selection
        validInput = true;
        boolean validInput2 = false;
        do
        {
            //If user selects "All the countries in..."
            if (userInput == "1")
            {
                //Display options
                System.out.println("All the countries in...");
                System.out.println("1. The world");
                System.out.println("2. A particular continent");
                System.out.println("3. A particular region");

                //Read user input
                String userInput2 = scanner.next();

                //If user input is invalid, throw error message and ask again
                if (userInput2 == "1" || userInput2 == "2" || userInput2 == "3")
                {
                    //If user selects "All the countries in the world"
                    if (userInput2 == "1")
                    {
                        //Display all the countries in the world
                        validInput2 = true;
                        DisplayResults dr = new DisplayResults();
                        dr.countriesInWorld();
                    }
                    else
                    {
                        //Prevent other options from being selected until functionality is implemented
                        System.out.println("ERROR: This option is currently unavailable.");
                        validInput2 = false;
                    }
                }
                else
                {
                    System.out.println("ERROR: Invalid option selected");
                    validInput2 = false;
                }
            }
            //Prevent other options being selected until functionality is implemented
            else
            {
                System.out.println("ERROR: This option is currently unavailable.");
                validInput2 = false;
            }
        } while (validInput2 == false);
    }
    */
}