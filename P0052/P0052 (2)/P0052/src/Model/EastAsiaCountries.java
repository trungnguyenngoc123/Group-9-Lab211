/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class EastAsiaCountries {
 protected String countryCode;
 protected String countryName;   
 protected float totalArea;

    public EastAsiaCountries() {
    }
 

    public EastAsiaCountries(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }
 
 public void display(){

 }

 @Override
   public String toString() {
   
    return String.format("%-15s %-20s %-15f", countryCode, countryName, totalArea);
}

}
