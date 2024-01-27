/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.PrintStream;


public class DevelopCountry extends EastAsiaCountries {
 private String countryTerrain;

  public DevelopCountry() {
    }
   
    public DevelopCountry(String countryCode, String countryName, float totalArea, String countryTerrain) {
   super(countryCode,countryName,totalArea);
    this.countryTerrain = countryTerrain;
}


    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        super.display(); 
    }

 @Override
   public String toString() {
        
        return String.format("%-10s%-15s%-15s%-15s\n", getCountryCode(), getCountryName(), getTotalArea(), getCountryTerrain());
    }

   

   
}
