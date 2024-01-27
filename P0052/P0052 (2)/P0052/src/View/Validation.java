/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.DevelopCountry;
import java.util.ArrayList;
import java.util.Scanner;

public class Validation {
    public static final Scanner sc = new Scanner(System.in);
   public static String checkInputString(String t){
       System.out.print(t);
       while(true){
           String result = sc.nextLine().trim();
           if(result.isEmpty()){
               System.out.println("Not empty");
               System.out.print("Enter again: ");
           }
           else{
               return result;
           }
       }
   } 
   
   
   
public static float checkInputFloat(String t){
    System.out.print(t);
    while(true){
        try{
            float result = Float.parseFloat(sc.nextLine());
            return result;
        }
        catch(NumberFormatException e){
            System.out.println("Please enter a number");
            System.out.print("Enter again: ");
    }
}
}

public static boolean checkCountryExist(ArrayList<DevelopCountry> lc,String countryCode){
    for(DevelopCountry country: lc){
        if(country.getCountryCode().equalsIgnoreCase(countryCode)){
            return false;
        }
    }
    return true;
}

public static String checkCountryName(String t){
    System.out.print(t);
    while(true){
        String name = sc.nextLine().trim();
        String regex="^[a-zA-Z\\s'-]+$";
        if(name.matches(regex) && name.length()>=4){
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            return name;
        }
        else{
            System.out.println("Invalid input.Please enter a valid name without number and at least 4 characters");
            System.out.print("Enter again: ");
        }
    }
}
public static boolean checkInputYN(String t) {
        while (true) {
            String result = checkInputString(t);
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.err.println("Please input y/Y or n/N.");
                System.out.print("Enter again: ");
            }
        }
    }
}
