package com.napier.sem;

public class DisplayResults {

    //Instantiate Country class
    Country c = new Country();

    //Print table of results for all Countries in the World (Population largest to smallest)
    public void countriesInWorld()
    {
        //Check that there is data to display
        if (c.getCountries("inWorld",null) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%s %37s %15s %25s %10s %13s", "Code", "Country", "Continent", "Region", "Population", "Capital");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (Country cou: c.getCountries("inWorld", null))
            {
                System.out.format("%s %37s %15s %25s %10s %13s", cou.getCode(), cou.getName(),
                        cou.getContinent(), cou.getRegion(), cou.getPopulation(),
                        cou.getCapital());
                System.out.println();
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
        }
        //If there is no data to display, print error message
        else
        {
            System.out.println("No results to display.");
        }
    }

    //Print table of results for all Countries in a particular Continent (Population largest to smallest)
    public void countriesInContinent(String nameOfContinent)
    {
        //Check that there is data to display
        if (c.getCountries("inContinent", nameOfContinent) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%s %37s %15s %25s %10s %13s", "Code", "Country", "Continent", "Region", "Population", "Capital");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (Country cou: c.getCountries("inContinent", nameOfContinent))
            {
                System.out.format("%s %37s %15s %25s %10s %13s", cou.getCode(), cou.getName(),
                        cou.getContinent(), cou.getRegion(), cou.getPopulation(),
                        cou.getCapital());
                System.out.println();
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
        }
        //If there is no data to display, print error message
        else
        {
            System.out.println("No results to display.");
        }
    }

    //Print table of results for all Countries in a particular Region (Population largest to smallest
    public void countriesInRegion(String nameOfRegion)
    {
        //Check that there is data to display
        if (c.getCountries("inRegion", nameOfRegion) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%s %37s %15s %25s %10s %13s", "Code", "Country", "Continent", "Region", "Population", "Capital");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (Country cou: c.getCountries("inRegion", nameOfRegion))
            {
                System.out.format("%s %37s %15s %25s %10s %13s", cou.getCode(), cou.getName(),
                        cou.getContinent(), cou.getRegion(), cou.getPopulation(),
                        cou.getCapital());
                System.out.println();
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
        }
        //If there is no data to display, print error message
        else
        {
            System.out.println("No results to display.");
        }
    }
}
