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
        String strCode = Code == null ? "" : Code +" | " ;
        String strName = Name == null ? "" : Name +" | ";
        String strContinent = Continent == null ? "" : Continent +" | ";
        String strRegion = Region == null ? "" : Region +" | ";
        String strSurfaceArea = SurfaceArea == 0.0 ? "" : SurfaceArea +" | ";
        String strIndepYear = IndepYear == 0000 ? "" : IndepYear +" | ";
        String strPopulation = Population == 0 ? "" : Population +" | ";
        String strLifeExpectancy = LifeExpectancy == 0 ? "" : LifeExpectancy +" | ";
        String strGNP = GNP == 0 ? "" : GNP +" | ";
        String strGNPOld = GNPOld == 0 ? "" : GNPOld +" | ";
        String strLocalName = LocalName == null ? "" : LocalName +" | ";
        String strGovernmentForm = GovernmentForm == null ? "" : GovernmentForm +" | ";
        String strHeadOfState = HeadOfState == null ? "" : HeadOfState +" | ";
        String strCapital = Capital == null ? "" : Capital +" | ";
        String strCode2 = Code2 == null ? "" : Code2 +" | ";

        System.out.println(
                "| "+
                strCode
                + strName
                + strContinent
                + strRegion
                + strSurfaceArea
                + strIndepYear
                + strPopulation
                + strLifeExpectancy
                + strGNP
                + strGNPOld
                + strLocalName
                + strGovernmentForm
                + strHeadOfState
                + strCapital
                + strCode2 + "\n");
    }
}
