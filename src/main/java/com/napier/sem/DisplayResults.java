package com.napier.sem;

public class DisplayResults {

    //Instantiate Country class
    Country cou = new Country();
    //Instantiate City class
    City cit = new City();

    //Print table of results for all Countries in the World (Population largest to smallest)
    public void countriesInWorld()
    {
        //Check that there is data to display
        if (cou.getCountries("inWorld",null) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%s %37s %15s %25s %10s %13s", "Code", "Country", "Continent", "Region", "Population", "Capital");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (Country cou: cou.getCountries("inWorld", null))
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
        if (cou.getCountries("inContinent", nameOfContinent) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%s %37s %15s %25s %10s %13s", "Code", "Country", "Continent", "Region", "Population", "Capital");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (Country cou: cou.getCountries("inContinent", nameOfContinent))
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
        if (cou.getCountries("inRegion", nameOfRegion) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%s %37s %15s %25s %10s %13s", "Code", "Country", "Continent", "Region", "Population", "Capital");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (Country cou: cou.getCountries("inRegion", nameOfRegion))
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

    //Print table of results for all Cities in the world (Population largest to smallest)
    public void citiesInWorld()
    {
        //Check that there is data to display
        if (cit.getCities("inWorld", null) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%25s %25s %25s %25s", "City", "Country", "District", "Population");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (City cit: cit.getCities("inWorld", null))
            {
                System.out.format("%25s %25s %25s %25s", cit.getName(), cit.getCountry(),
                        cit.getDistrict(), cit.getPopulation());
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
