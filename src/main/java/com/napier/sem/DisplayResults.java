package com.napier.sem;

public class DisplayResults {

    //Instantiate Country class
    Country cou = new Country();
    //Instantiate City class
    City cit = new City();
    //Instantiate Capital City class
    CapitalCity capCit = new CapitalCity();
    //Instantiate Living In Cities class
    LivingInCities lic = new LivingInCities();
    //Instantiat General Population class
    GeneralPop gp = new GeneralPop();

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

    //Print table of results for all Cities in a particular continent (Population largest to smallest)
    public void citiesInContinent(String nameOfContinent)
    {
        //Check that there is data to display
        if (cit.getCities("inContinent", nameOfContinent) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%25s %25s %25s %25s", "City", "Country", "District", "Population");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (City cit: cit.getCities("inContinent", nameOfContinent))
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

    //Print table of results for all Cities in a particular region (Population largest to smallest)
    public void citiesInRegion(String nameOfRegion)
    {
        //Check that there is data to display
        if (cit.getCities("inRegion", nameOfRegion) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%25s %25s %25s %25s", "City", "Country", "District", "Population");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (City cit: cit.getCities("inRegion", nameOfRegion))
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

    //Print table of results for all Cities in a particular country (Population largest to smallest)
    public void citiesInCountry(String nameOfCountry)
    {
        //Check that there is data to display
        if (cit.getCities("inCountry", nameOfCountry) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%25s %25s %25s %25s", "City", "Country", "District", "Population");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (City cit: cit.getCities("inCountry", nameOfCountry))
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

    //Print table of results for all Cities in a particular district (Population largest to smallest)
    public void citiesInDistrict(String nameOfDistrict)
    {
        //Check that there is data to display
        if (cit.getCities("inDistrict", nameOfDistrict) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%25s %25s %25s %25s", "City", "Country", "District", "Population");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (City cit: cit.getCities("inDistrict", nameOfDistrict))
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

    //Print table of results for all Capital Cities in the world (Population largest to smallest)
    public void capitalCitiesInWorld()
    {
        //Check that there is data to display
        if (capCit.getCapitalCities("inWorld", null) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%40s %30s %30s", "Capital City", "Country", "Population");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (CapitalCity capCit: capCit.getCapitalCities("inWorld", null))
            {
                System.out.format("%40s %30s %30s", capCit.getName(), capCit.getCountry(),
                        capCit.getPopulation());
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

    //Print table of results for all Capital Cities in a particular continent (Population largest to smallest)
    public void capitalCitiesInContinent(String nameOfContinent)
    {
        //Check that there is data to display
        if (capCit.getCapitalCities("inContinent", nameOfContinent) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%40s %30s %30s", "Capital City", "Country", "Population");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (CapitalCity capCit: capCit.getCapitalCities("inContinent", nameOfContinent))
            {
                System.out.format("%40s %30s %30s", capCit.getName(), capCit.getCountry(),
                        capCit.getPopulation());
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

    //Print table of results for all Capital Cities in a particular region (Population largest to smallest)
    public void capitalCitiesInRegion(String nameOfRegion)
    {
        //Check that there is data to display
        if (capCit.getCapitalCities("inRegion", nameOfRegion) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%40s %30s %30s", "Capital City", "Country", "Population");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (CapitalCity capCit: capCit.getCapitalCities("inRegion", nameOfRegion))
            {
                System.out.format("%40s %30s %30s", capCit.getName(), capCit.getCountry(),
                        capCit.getPopulation());
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

    //Print table of results for those living/not living in cities in each continent (Population largest to smallest)
    public void livingInCitiesInContinents()
    {
        //Check that there is data to display
        if (lic.getLivingInCities("inContinents") != null)
        {
            //If there is data to display, display data in table format
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%20s %20s %20s %20s %20s %20s", "Continent", "Total Population", "Pop. In Cities",
                    "% in Cities", "Pop NOT in Cities", "% NOT in Cities");
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            for (LivingInCities lic: lic.getLivingInCities("inContinents"))
            {
                System.out.format("%20s %20s %20s %20s %20s %20s", lic.getContinent(), lic.getPopulation(),
                        lic.getLivingInCities(), lic.getPercentageInCities(), lic.getNotInCities(),
                        lic.getPercentageNotInCities());
                System.out.println();
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        }
        //If there is no data to display, print error message
        else
        {
            System.out.println("No results to display.");
        }
    }

    //Print table of results for those living/not living in cities in each region (Population largest to smallest)
    public void livingInCitiesInRegions()
    {
        //Check that there is data to display
        if (lic.getLivingInCities("inRegions") != null)
        {
            //If there is data to display, display data in table format
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%20s %20s %20s %20s %20s %20s", "Region", "Total Population", "Pop. In Cities",
                    "% in Cities", "Pop NOT in Cities", "% NOT in Cities");
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            for (LivingInCities lic: lic.getLivingInCities("inRegions"))
            {
                System.out.format("%20s %20s %20s %20s %20s %20s", lic.getRegion(), lic.getPopulation(),
                        lic.getLivingInCities(), lic.getPercentageInCities(), lic.getNotInCities(),
                        lic.getPercentageNotInCities());
                System.out.println();
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        }
        //If there is no data to display, print error message
        else
        {
            System.out.println("No results to display.");
        }
    }

    //Print table of results for those living/not living in cities in each country (Population largest to smallest)
    public void livingInCitiesInCountries()
    {
        //Check that there is data to display
        if (lic.getLivingInCities("inCountries") != null)
        {
            //If there is data to display, display data in table format
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%20s %20s %20s %20s %20s %20s", "Country", "Total Population", "Pop. In Cities",
                    "% in Cities", "Pop NOT in Cities", "% NOT in Cities");
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            for (LivingInCities lic: lic.getLivingInCities("inCountries"))
            {
                System.out.format("%20s %20s %20s %20s %20s %20s", lic.getCountry(), lic.getPopulation(),
                        lic.getLivingInCities(), lic.getPercentageInCities(), lic.getNotInCities(),
                        lic.getPercentageNotInCities());
                System.out.println();
            }
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        }
        //If there is no data to display, print error message
        else
        {
            System.out.println("No results to display.");
        }
    }

    //Display population of the world
    public void populationOfTheWorld()
    {
        //As long as the query doesn't return an error
        if (gp.getWorldPop() != 0)
        {
            System.out.println();
            System.out.println("The population of the world is: " + gp.getWorldPop());
            System.out.println();
        }
        else
        {
            System.out.println("No result to display.");
        }
    }

    //Display population of a particular continent
    public void populationOfContinent(String continent)
    {
        //As long as the query doesn't return an error
        if (gp.getContinentPop(continent) != 0)
        {
            System.out.println();
            System.out.println("The population of " + continent + " is: " + gp.getContinentPop(continent));
            System.out.println();
        }
        else
        {
            System.out.println("No result to display.");
        }
    }

    //Display population of a particular region
    public void populationOfRegion(String region)
    {
        //As long as the query doesn't return an error
        if (gp.getRegionPop(region) != 0)
        {
            System.out.println();
            System.out.println("The population of " + region + " is: " + gp.getRegionPop(region));
            System.out.println();
        }
        else
        {
            System.out.println("No result to display.");
        }
    }

    //Display population of a particular country
    public void populationOfCountry(String country)
    {
        //As long as the query doesn't return an error
        if (gp.getCountryPop(country) != 0)
        {
            System.out.println();
            System.out.println("The population of " + country + " is: " + gp.getCountryPop(country));
            System.out.println();
        }
        else
        {
            System.out.println("No result to display.");
        }
    }
}
