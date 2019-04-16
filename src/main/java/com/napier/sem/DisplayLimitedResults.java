package com.napier.sem;

public class DisplayLimitedResults {

    //Instantiate Country class
    Country cou = new Country();
    //Instantiate City class
    City cit = new City();
    //Instantiate Capital City class
    CapitalCity capCit = new CapitalCity();
    //Instantiate Living In Cities class
    LivingInCities lic = new LivingInCities();

    //Print table of results for all Countries in the World (Population largest to smallest)
    public void countriesInWorld(int limit)
    {
        //Check that there is data to display
        if (cou.getCountries("inWorld",null) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%s %37s %15s %25s %10s %13s", "Code", "Country", "Continent", "Region", "Population", "Capital");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < limit; i++)
            {
                Country c = cou.getCountries("inWorld", null).get(i);
                System.out.format("%s %37s %15s %25s %10s %13s", c.getCode(), c.getName(),
                        c.getContinent(), c.getRegion(), c.getPopulation(),
                        c.getCapital());
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
    public void countriesInContinent(String nameOfContinent, int limit)
    {
        //Check that there is data to display
        if (cou.getCountries("inContinent", nameOfContinent) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%s %37s %15s %25s %10s %13s", "Code", "Country", "Continent", "Region", "Population", "Capital");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < limit; i++)
            {
                Country c = cou.getCountries("inContinent", nameOfContinent).get(i);
                System.out.format("%s %37s %15s %25s %10s %13s", c.getCode(), c.getName(),
                        c.getContinent(), c.getRegion(), c.getPopulation(),
                        c.getCapital());
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
    public void countriesInRegion(String nameOfRegion, int limit)
    {
        //Check that there is data to display
        if (cou.getCountries("inRegion", nameOfRegion) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%s %37s %15s %25s %10s %13s", "Code", "Country", "Continent", "Region", "Population", "Capital");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < limit; i++)
            {
                Country c = cou.getCountries("inRegion", nameOfRegion).get(i);
                System.out.format("%s %37s %15s %25s %10s %13s", c.getCode(), c.getName(),
                        c.getContinent(), c.getRegion(), c.getPopulation(),
                        c.getCapital());
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
    public void citiesInWorld(int limit)
    {
        //Check that there is data to display
        if (cit.getCities("inWorld", null) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%25s %25s %25s %25s", "City", "Country", "District", "Population");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < limit; i++)
            {
                City c = cit.getCities("inWorld", null).get(i);
                System.out.format("%25s %25s %25s %25s", c.getName(), c.getCountry(),
                        c.getDistrict(), c.getPopulation());
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
    public void citiesInContinent(String nameOfContinent, int limit)
    {
        //Check that there is data to display
        if (cit.getCities("inContinent", nameOfContinent) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%25s %25s %25s %25s", "City", "Country", "District", "Population");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < limit; i++)
            {
                City c = cit.getCities("inContinent", nameOfContinent).get(i);
                System.out.format("%25s %25s %25s %25s", c.getName(), c.getCountry(),
                        c.getDistrict(), c.getPopulation());
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
    public void citiesInRegion(String nameOfRegion, int limit)
    {
        //Check that there is data to display
        if (cit.getCities("inRegion", nameOfRegion) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%25s %25s %25s %25s", "City", "Country", "District", "Population");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < limit; i++)
            {
                City c = cit.getCities("inRegion", nameOfRegion).get(i);
                System.out.format("%25s %25s %25s %25s", c.getName(), c.getCountry(),
                        c.getDistrict(), c.getPopulation());
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
    public void citiesInCountry(String nameOfCountry, int limit)
    {
        //Check that there is data to display
        if (cit.getCities("inCountry", nameOfCountry) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%25s %25s %25s %25s", "City", "Country", "District", "Population");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < limit; i++)
            {
                City c = cit.getCities("inCountry", nameOfCountry).get(i);
                System.out.format("%25s %25s %25s %25s", c.getName(), c.getCountry(),
                        c.getDistrict(), c.getPopulation());
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
    public void citiesInDistrict(String nameOfDistrict, int limit)
    {
        //Check that there is data to display
        if (cit.getCities("inDistrict", nameOfDistrict) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%25s %25s %25s %25s", "City", "Country", "District", "Population");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < limit; i++)
            {
                City c = cit.getCities("inDistrict", nameOfDistrict).get(i);
                System.out.format("%25s %25s %25s %25s", c.getName(), c.getCountry(),
                        c.getDistrict(), c.getPopulation());
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
    public void capitalCitiesInWorld(int limit)
    {
        //Check that there is data to display
        if (capCit.getCapitalCities("inWorld", null) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%40s %30s %30s", "Capital City", "Country", "Population");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < limit; i++)
            {
                CapitalCity c = capCit.getCapitalCities("inWorld", null).get(i);
                System.out.format("%40s %30s %30s", c.getName(), c.getCountry(),
                        c.getPopulation());
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
    public void capitalCitiesInContinent(String nameOfContinent, int limit)
    {
        //Check that there is data to display
        if (capCit.getCapitalCities("inContinent", nameOfContinent) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%40s %30s %30s", "Capital City", "Country", "Population");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < limit; i++)
            {
                CapitalCity c = capCit.getCapitalCities("inContinent", nameOfContinent).get(i);
                System.out.format("%40s %30s %30s", c.getName(), c.getCountry(),
                        c.getPopulation());
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
    public void capitalCitiesInRegion(String nameOfRegion, int limit)
    {
        //Check that there is data to display
        if (capCit.getCapitalCities("inRegion", nameOfRegion) != null)
        {
            //If there is data to display, display data in table format
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            System.out.printf("%40s %30s %30s", "Capital City", "Country", "Population");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < limit; i++)
            {
                CapitalCity c = capCit.getCapitalCities("inRegion", nameOfRegion).get(i);
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
    public void livingInCitiesInContinents(int limit)
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
            for (int i = 0; i < limit; i++)
            {
                LivingInCities lc = lic.getLivingInCities("inContinents").get(i);
                System.out.format("%20s %20s %20s %20s %20s %20s", lc.getContinent(), lc.getPopulation(),
                        lc.getLivingInCities(), lc.getPercentageInCities(), lc.getNotInCities(),
                        lc.getPercentageNotInCities());
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
    public void livingInCitiesInRegions(int limit)
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
            for (int i = 0; i < limit; i++)
            {
                LivingInCities lc = lic.getLivingInCities("inRegions").get(i);
                System.out.format("%20s %20s %20s %20s %20s %20s", lc.getRegion(), lc.getPopulation(),
                        lc.getLivingInCities(), lc.getPercentageInCities(), lc.getNotInCities(),
                        lc.getPercentageNotInCities());
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
    public void livingInCitiesInCountries(int limit)
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
            for (int i = 0; i < limit; i++)
            {
                LivingInCities lc = lic.getLivingInCities("inCountries").get(i);
                System.out.format("%20s %20s %20s %20s %20s %20s", lc.getCountry(), lc.getPopulation(),
                        lc.getLivingInCities(), lc.getPercentageInCities(), lc.getNotInCities(),
                        lc.getPercentageNotInCities());
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
}
