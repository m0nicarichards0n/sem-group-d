package com.napier.sem;

import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Display user options and display appropriate tables based on request
        a.displayUserSelection();

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    public static Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect() {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(10000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public void displayUserSelection() {

        boolean repeat = true;
        //Instantiate new set of results
        DisplayResults displayResults = new DisplayResults();

        while (repeat)
        {
            //Display main menu
            mainMenu();
            //Read user input
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.next();

            //Based on user input, return different table
            switch (userInput) {
                //If user wants to see all the countries in...
                case "1":
                    switch (countriesMenu()) {
                        //...the world
                        case "1":
                            //Display all countries in the world
                            displayResults.countriesInWorld();
                            break;
                        //...a particular  continent
                        case "2":
                            //Ask which continent
                            System.out.println("Which continent?");
                            //Read user input
                            scanner.nextLine();
                            String continent = scanner.nextLine();
                            //Display all countries in that particular continent
                            displayResults.countriesInContinent(continent);
                            break;
                        //...a particular region
                        case "3":
                            //Ask which region
                            System.out.println("Which region?");
                            //Read user input
                            scanner.nextLine();
                            String region = scanner.nextLine();
                            //Display all countries in that particular region
                            displayResults.countriesInRegion(region);
                            break;
                        //return to main menu if user presses 'x'
                        case "x":
                            break;
                    }
                    break;
                //If user wants to see all the cities in...
                case "2":
                    switch (citiesMenu()) {
                        //...the world
                        case "1":
                            //Display all cities in the world
                            displayResults.citiesInWorld();
                            break;
                        //...a particular continent
                        case "2":
                            //Ask which continent
                            System.out.println("Which continent?");
                            //Read user input
                            scanner.nextLine();
                            String continent = scanner.nextLine();
                            //Display all cities in that particular continent
                            displayResults.citiesInContinent(continent);
                            break;
                        //...a particular region
                        case "3":
                            //Ask which region
                            System.out.println("Which region?");
                            //Read user input
                            scanner.nextLine();
                            String region = scanner.nextLine();
                            //Display all cities in that particular region
                            displayResults.citiesInRegion(region);
                            break;
                        //...a particular country
                        case "4":
                            //Ask which country
                            System.out.println("Which country?");
                            //Read user input
                            scanner.nextLine();
                            String country = scanner.nextLine();
                            //Display all cities in that particular country
                            displayResults.citiesInCountry(country);
                            break;
                        //...a particular district
                        case "5":
                            //Ask which district
                            System.out.println("Which district?");
                            //Read user input
                            scanner.nextLine();
                            String district = scanner.nextLine();
                            //Display all cities in that particular district
                            displayResults.citiesInDistrict(district);
                            break;
                        //return to main menu if user presses 'x'
                        case "x":
                            break;
                    }
                    break;
                //If user wants to see all the capital cities in...
                case "3":
                    switch (capitalCitiesMenu()) {
                        //...the world
                        case "1":
                            //Display all countries in the world
                            displayResults.capitalCitiesInWorld();
                            break;
                        //...a particular  continent
                        case "2":
                            //display countries in that particular continent
                            break;
                        //...a particular region
                        case "3":
                            //display countries in a particular region
                            break;
                        //return to main menu if user presses 'x'
                        case "x":
                            break;
                    }
                    break;
                //If user wants to see the population of...
                case "4":
                    switch (populationMenu()) {
                        //...people living in cities and not living in cities in a particular continent
                        case "1":
                            //display appropriate results
                            break;
                        //...people living in cities and not living in cities in a particular region
                        case "2":
                            //display appropriate results
                            break;
                        //...people living in cities and not living in cities in a particular country
                        case "3":
                            //display appropriate results
                            break;
                        //...the world
                        case "4":
                            //display appropriate results
                            break;
                        //...a particular continent
                        case "5":
                            //display appropriate results
                            break;
                        //...a particular region
                        case "6":
                            //display appropriate results
                            break;
                        //...a particular country
                        case "7":
                            //display appropriate results
                            break;
                        //...a particular district
                        case "8":
                            //display appropriate results
                            break;
                        //...a particular city
                        case "9":
                            //display appropriate results
                            break;
                        //return to main menu if user presses 'x'
                        case "x":
                            break;
                    }
                    break;
                //If user presses 'x' to exit the programme
                case "x":
                    repeat = false;
                break;
            }
        }
    }

    public void mainMenu() {

        //Display main menu options
        System.out.println("Welcome to the Population Database!");
        System.out.println("I would like to view...");
        System.out.println("1. All the countries in...");
        System.out.println("2. All the cities in...");
        System.out.println("3. All the capital cities in...");
        System.out.println("4. The population of...");
        System.out.println("Press 'x' to exit the programme");

    }

    public String countriesMenu() {

        //Display country options
        System.out.println("All the countries in...");
        System.out.println("1. The world");
        System.out.println("2. A particular continent");
        System.out.println("3. A particular region");
        System.out.println("Press 'x' to return to the main menu");

        //Return user input
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        return userInput;
    }

    public String citiesMenu() {

        //Display city options
        System.out.println("All the cities in...");
        System.out.println("1. The world");
        System.out.println("2. A particular continent");
        System.out.println("3. A particular region");
        System.out.println("4. A particular country");
        System.out.println("5. A particular district");
        System.out.println("Press 'x' to return to the main menu");

        //Return user input
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        return userInput;
    }

    public String capitalCitiesMenu() {

        //Display capital city options
        System.out.println("All the capital cities in...");
        System.out.println("1. The world");
        System.out.println("2. A particular continent");
        System.out.println("3. A particular region");
        System.out.println("Press 'x' to return to the main menu");

        //Return user input
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        return userInput;
    }

    public String populationMenu() {
        //Display population options
        System.out.println("The population of...");
        System.out.println("1. People living in cities and not living in cities in a particular continent");
        System.out.println("2. People living in cities and not living in cities in a particular region");
        System.out.println("3. People living in cities and not living in cities in a particular country");
        System.out.println("4. The world");
        System.out.println("5. A particular continent");
        System.out.println("6. A particular region");
        System.out.println("7. A particular country");
        System.out.println("8. A particular district");
        System.out.println("9. A particular city");
        System.out.println("Press 'x' to return to the main menu");

        //Return user input
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.next();
        return userInput;
    }
}