package com.napier.sem;

import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        // Connect to database
        if (args.length < 1)
        {
            a.connect("localhost:33060");
        }
        else
        {
            a.connect(args[0]);
        }

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
    public void connect(String location) {
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
                con = DriverManager.getConnection("jdbc:mysql://"+ location +"/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
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
        //Instantiate new set of limited results
        DisplayLimitedResults displayLimitedResults = new DisplayLimitedResults();

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
                            //Ask if user wishes to limit the number of results displayed
                            System.out.println("Do you wish to limit the number of countries displayed? (y/n)");
                            //Read user input
                            scanner.nextLine();
                            String limit1 = scanner.nextLine();
                            if (limit1.equals("y"))
                            {
                                //Ask how many countries to display
                                System.out.println("How many of the top populated countries in the world do you wish to see?");
                                //Read user input
                                String howMany = scanner.nextLine();
                                try
                                {
                                    displayLimitedResults.countriesInWorld(Integer.parseInt(howMany));
                                }
                                catch(Exception e)
                                {
                                    System.out.println("Invalid user input");
                                    break;
                                }
                            }
                            else if (limit1.equals("n"))
                            {
                                //Display all countries in the world
                                displayResults.countriesInWorld();
                            }
                            break;
                        //...a particular  continent
                        case "2":
                            //Ask which continent
                            System.out.println("Which continent?");
                            //Read user input
                            scanner.nextLine();
                            String continent = scanner.nextLine();
                            //Ask if user wishes to limit the number of results displayed
                            System.out.println("Do you wish to limit the number of countries displayed? (y/n)");
                            //Read user input
                            String limit2 = scanner.nextLine();
                            if (limit2.equals("y")) {
                                //Ask how many countries to display
                                System.out.println("How many of the top populated countries in this continent do you wish to see?");
                                //Read user input
                                String howMany = scanner.nextLine();
                                try
                                {
                                    displayLimitedResults.countriesInContinent(continent, Integer.parseInt(howMany));
                                }
                                catch(Exception e)
                                {
                                    System.out.println("Invalid user input");
                                    break;
                                }
                            }
                            else if (limit2.equals("n"))
                            {
                                //Display all countries in that particular continent
                                displayResults.countriesInContinent(continent);
                            }
                            break;
                        //...a particular region
                        case "3":
                            //Ask which region
                            System.out.println("Which region?");
                            //Read user input
                            scanner.nextLine();
                            String region = scanner.nextLine();
                            //Ask if user wishes to limit the number of results displayed
                            System.out.println("Do you wish to limit the number of countries displayed? (y/n)");
                            //Read user input
                            String limit3 = scanner.nextLine();
                            if (limit3.equals("y")) {
                                //Ask how many countries to display
                                System.out.println("How many of the top populated countries in this region do you wish to see?");
                                //Read user input
                                String howMany = scanner.nextLine();
                                try
                                {
                                    displayLimitedResults.countriesInRegion(region, Integer.parseInt(howMany));
                                }
                                catch(Exception e)
                                {
                                    System.out.println("Invalid user input");
                                    break;
                                }
                            }
                            else if (limit3.equals("n"))
                            {
                                //Display all countries in that particular region
                                displayResults.countriesInRegion(region);
                            }
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
                            //Ask if user wishes to limit the number of results displayed
                            System.out.println("Do you wish to limit the number of cities displayed? (y/n)");
                            //Read user input
                            String limit4 = scanner.nextLine();
                            if (limit4.equals("y")) {
                                //Ask how many cities to display
                                System.out.println("How many of the top populated cities in the world do you wish to see?");
                                //Read user input
                                String howMany = scanner.nextLine();
                                try
                                {
                                    displayLimitedResults.citiesInWorld(Integer.parseInt(howMany));
                                }
                                catch(Exception e)
                                {
                                    System.out.println("Invalid user input");
                                    break;
                                }
                            }
                            else if (limit4.equals("n"))
                            {
                                //Display all cities in the world
                                displayResults.citiesInWorld();
                            }
                            break;
                        //...a particular continent
                        case "2":
                            //Ask which continent
                            System.out.println("Which continent?");
                            //Read user input
                            scanner.nextLine();
                            String continent = scanner.nextLine();
                            //Ask if user wishes to limit the number of results displayed
                            System.out.println("Do you wish to limit the number of cities displayed? (y/n)");
                            //Read user input
                            String limit5 = scanner.nextLine();
                            if (limit5.equals("y")) {
                                //Ask how many countries to display
                                System.out.println("How many of the top populated cities in this continent do you wish to see?");
                                //Read user input
                                String howMany = scanner.nextLine();
                                try
                                {
                                    displayLimitedResults.citiesInContinent(continent, Integer.parseInt(howMany));
                                }
                                catch(Exception e)
                                {
                                    System.out.println("Invalid user input");
                                    break;
                                }
                            }
                            else if (limit5.equals("n"))
                            {
                                //Display all cities in that particular continent
                                displayResults.citiesInContinent(continent);
                            }
                            break;
                        //...a particular region
                        case "3":
                            //Ask which region
                            System.out.println("Which region?");
                            //Read user input
                            scanner.nextLine();
                            String region = scanner.nextLine();
                            //Ask if user wishes to limit the number of results displayed
                            System.out.println("Do you wish to limit the number of cities displayed? (y/n)");
                            //Read user input
                            String limit6 = scanner.nextLine();
                            if (limit6.equals("y")) {
                                //Ask how many cities to display
                                System.out.println("How many of the top populated cities in this region do you wish to see?");
                                //Read user input
                                String howMany = scanner.nextLine();
                                try
                                {
                                    displayLimitedResults.citiesInRegion(region, Integer.parseInt(howMany));
                                }
                                catch(Exception e)
                                {
                                    System.out.println("Invalid user input");
                                    break;
                                }
                            }
                            else if (limit6.equals("n"))
                            {
                                //Display all cities in that particular region
                                displayResults.citiesInRegion(region);
                            }
                            break;
                        //...a particular country
                        case "4":
                            //Ask which country
                            System.out.println("Which country?");
                            //Read user input
                            scanner.nextLine();
                            String country = scanner.nextLine();
                            //Ask if user wishes to limit the number of results displayed
                            System.out.println("Do you wish to limit the number of cities displayed? (y/n)");
                            //Read user input
                            String limit7 = scanner.nextLine();
                            if (limit7.equals("y")) {
                                //Ask how many cities to display
                                System.out.println("How many of the top populated cities in this country do you wish to see?");
                                //Read user input
                                String howMany = scanner.nextLine();
                                try
                                {
                                    displayLimitedResults.citiesInCountry(country, Integer.parseInt(howMany));
                                }
                                catch(Exception e)
                                {
                                    System.out.println("Invalid user input");
                                    break;
                                }
                            }
                            else if (limit7.equals("n"))
                            {
                                //Display all cities in that particular country
                                displayResults.citiesInCountry(country);
                            }
                            break;
                        //...a particular district
                        case "5":
                            //Ask which district
                            System.out.println("Which district?");
                            //Read user input
                            scanner.nextLine();
                            String district = scanner.nextLine();
                            //Ask if user wishes to limit the number of results displayed
                            System.out.println("Do you wish to limit the number of cities displayed? (y/n)");
                            //Read user input
                            String limit8 = scanner.nextLine();
                            if (limit8.equals("y")) {
                                //Ask how many cities to display
                                System.out.println("How many of the top populated cities in this district do you wish to see?");
                                //Read user input
                                String howMany = scanner.nextLine();
                                try
                                {
                                    displayLimitedResults.citiesInDistrict(district, Integer.parseInt(howMany));
                                }
                                catch(Exception e)
                                {
                                    System.out.println("Invalid user input");
                                    break;
                                }
                            }
                            else if (limit8.equals("n"))
                            {
                                //Display all cities in that particular district
                                displayResults.citiesInDistrict(district);
                            }
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
                            //Ask if user wishes to limit the number of results displayed
                            System.out.println("Do you wish to limit the number of capital cities displayed? (y/n)");
                            //Read user input
                            String limit9 = scanner.nextLine();
                            if (limit9.equals("y")) {
                                //Ask how many capital cities to display
                                System.out.println("How many of the top populated capital cities in the world do you wish to see?");
                                //Read user input
                                String howMany = scanner.nextLine();
                                try
                                {
                                    displayLimitedResults.capitalCitiesInWorld(Integer.parseInt(howMany));
                                }
                                catch(Exception e)
                                {
                                    System.out.println("Invalid user input");
                                    break;
                                }
                            }
                            else if (limit9.equals("n"))
                            {
                                //Display all capital cities in the world
                                displayResults.capitalCitiesInWorld();
                            }
                            break;
                        //...a particular  continent
                        case "2":
                            //Ask which continent
                            System.out.println("Which continent?");
                            //Read user input
                            scanner.nextLine();
                            String continent = scanner.nextLine();
                            //Ask if user wishes to limit the number of results displayed
                            System.out.println("Do you wish to limit the number of capital cities displayed? (y/n)");
                            //Read user input
                            String limit10 = scanner.nextLine();
                            if (limit10.equals("y")) {
                                //Ask how many capital cities to display
                                System.out.println("How many of the top populated capital cities in this continent do you wish to see?");
                                //Read user input
                                String howMany = scanner.nextLine();
                                try
                                {
                                    displayLimitedResults.capitalCitiesInContinent(continent, Integer.parseInt(howMany));
                                }
                                catch(Exception e)
                                {
                                    System.out.println("Invalid user input");
                                    break;
                                }
                            }
                            else if (limit10.equals("n"))
                            {
                                //Display all capital cities in that particular continent
                                displayResults.capitalCitiesInContinent(continent);
                            }
                            break;
                        //...a particular region
                        case "3":
                            //Ask which region
                            System.out.println("Which region?");
                            //Read user input
                            scanner.nextLine();
                            String region = scanner.nextLine();
                            //Ask if user wishes to limit the number of results displayed
                            System.out.println("Do you wish to limit the number of capital cities displayed? (y/n)");
                            //Read user input
                            String limit11 = scanner.nextLine();
                            if (limit11.equals("y")) {
                                //Ask how many capital cities to display
                                System.out.println("How many of the top populated capital cities in this region do you wish to see?");
                                //Read user input
                                String howMany = scanner.nextLine();
                                try
                                {
                                    displayLimitedResults.capitalCitiesInRegion(region, Integer.parseInt(howMany));
                                }
                                catch(Exception e)
                                {
                                    System.out.println("Invalid user input");
                                    break;
                                }
                            }
                            else if (limit11.equals("n"))
                            {
                                //Display all capital cities in that particular region
                                displayResults.capitalCitiesInRegion(region);
                            }
                            break;
                        //return to main menu if user presses 'x'
                        case "x":
                            break;
                    }
                    break;
                //If user wants to see the population of...
                case "4":
                    switch (populationMenu()) {
                        //...people living in cities and not living in cities in each continent
                        case "1":
                            //Display table showing population living/not living in cities in each continent
                            displayResults.livingInCitiesInContinents();
                            break;
                        //...people living in cities and not living in cities in each region
                        case "2":
                            //Display table showing population living/not living in cities in each region
                            displayResults.livingInCitiesInRegions();
                            break;
                        //...people living in cities and not living in cities in each country
                        case "3":
                            //Display table showing population living/not living in cities in each country
                            displayResults.livingInCitiesInCountries();
                            break;
                        //...the world
                        case "4":
                            //Display the population of the world
                            displayResults.populationOfTheWorld();
                            break;
                        //...a particular continent
                        case "5":
                            //Ask which continent
                            System.out.println("Which continent?");
                            //Read user input
                            scanner.nextLine();
                            String continent = scanner.nextLine();
                            //Display the population of that continent
                            displayResults.populationOfContinent(continent);
                            break;
                        //...a particular region
                        case "6":
                            //Ask which region
                            System.out.println("Which region?");
                            //Read user input
                            scanner.nextLine();
                            String region = scanner.nextLine();
                            //Display the population of that region
                            displayResults.populationOfRegion(region);
                            break;
                        //...a particular country
                        case "7":
                            //Ask which country
                            System.out.println("Which country?");
                            //Read user input
                            scanner.nextLine();
                            String country = scanner.nextLine();
                            //Display the population of that country
                            displayResults.populationOfCountry(country);
                            break;
                        //...a particular district
                        case "8":
                            //Ask which district
                            System.out.println("Which district?");
                            //Read user input
                            scanner.nextLine();
                            String district = scanner.nextLine();
                            //Display the population of that district
                            displayResults.populationOfDistrict(district);
                            break;
                        //...a particular city
                        case "9":
                            //Ask which city
                            System.out.println("Which city?");
                            //Read user input
                            scanner.nextLine();
                            String city = scanner.nextLine();
                            //Display the population of that city
                            displayResults.populationOfCity(city);
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
        System.out.println("1. People living in cities and not living in cities in each continent");
        System.out.println("2. People living in cities and not living in cities in each region");
        System.out.println("3. People living in cities and not living in cities in each country");
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