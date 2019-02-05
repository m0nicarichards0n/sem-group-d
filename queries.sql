SQL statements

--All the countries in the world organised by largest population to smallest.
SELECT *
FROM world
ORDER BY population DESC;

--All the countries in a continent organised by largest population to smallest.
SELECT *
FROM world
WHERE continent LIKE 'Asia'
ORDER BY population DESC;

--All the countries in a region organised by largest population to smallest.

--The top N populated countries in the world where N is provided by the user.
SELECT *
FROM world
ORDER BY population DESC
LIMIT 10;



--The top N populated countries in a continent where N is provided by the user.
SELECT *
FROM world
WHERE continent LIKE 'Asia'
ORDER BY population DESC
LIMIT 10;

--The top N populated countries in a region where N is provided by the user.
--All the cities in the world organised by largest population to smallest.
--All the cities in a continent organised by largest population to smallest.
--All the cities in a region organised by largest population to smallest.
--All the cities in a country organised by largest population to smallest.
--All the cities in a district organised by largest population to smallest.
--The top N populated cities in the world where N is provided by the user.
--The top N populated cities in a continent where N is provided by the user.
--The top N populated cities in a region where N is provided by the user.
--The top N populated cities in a country where N is provided by the user.
--The top N populated cities in a district where N is provided by the user.
--All the capital cities in the world organised by largest population to smallest.
--All the capital cities in a continent organised by largest population to smallest.
--All the capital cities in a region organised by largest to smallest.
--The top N populated capital cities in the world where N is provided by the user.
--The top N populated capital cities in a continent where N is provided by the user.
--The top N populated capital cities in a region where N is provided by the user.
--The population of people, people living in cities, and people not living in cities in each continent.
--The population of people, people living in cities, and people not living in cities in each region.
--The population of people, people living in cities, and people not living in cities in each country.
