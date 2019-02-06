package com.napier.sem;

public class Country
{
    public String Code;
    public String Name;
    public String Continent;
    public String Region;
    public double SurfaceArea;
    public int IndepYear;
    public int Population;
    public double LifeExpectancy;
    public double GNP;
    public double GNPOld;
    public String LocalName;
    public String GovernmentForm;
    public String HeadOfState;
    public String Capital;
    public String Code2;



    public Country(){

    }
    public void displayTable()
    {
        System.out.println(
                "| " + Code + " | "
                + Name + " | "
                + Continent + " | "
                + Region + " | "
                + SurfaceArea + " | "
                + IndepYear + " | "
                + Population + " | "
                + LifeExpectancy + " | "
                + GNP + " | "
                + GNPOld + " | "
                + LocalName + " | "
                + GovernmentForm + " | "
                + HeadOfState + " | "
                + Capital + " | "
                + Code2 + " |\n");
    }
}
