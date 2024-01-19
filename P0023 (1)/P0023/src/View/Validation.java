
package View;

import Model.Fruit;
import java.util.ArrayList;
import java.util.Scanner;

public class Validation {
    public static final Scanner sc = new Scanner (System.in);
    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range: [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    public static String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
    public static String checkInputName() {
        while (true) {
            String result = sc.nextLine().trim();
            String regex ="^[a-zA-Z\\s'-]+$";
            if (result.matches(regex)&& result.length() >= 2) {         
                result = result.substring(0, 1).toUpperCase() + result.substring(1).toLowerCase();
                return result;
            } else {
                System.err.println("Invalid input. Please enter a valid name without number and at least two character.");
                System.out.print("Enter again: ");
            }
        }
    }
    public static double checkInputDouble(){
        while(true){
            try{
                double result = Double.parseDouble(sc.nextLine());
                return result;
            }catch(NumberFormatException e){
                System.err.println("Invalid input, please input again!");
            }
        }
    }
    public static int checkInputInt(){
        while(true){
            try{
                int result = Integer.parseInt(sc.nextLine());
                return result;
            }catch(NumberFormatException e){
                System.err.println("Invalid input, please input again!");
            }
        }
    }
    public static boolean checkInputYN() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }else{
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
            }
        }
    }
    public static boolean checkIdExist(ArrayList<Fruit> ls, String id) {
        for (Fruit fruit : ls) {
            if (id.equalsIgnoreCase(fruit.getFruitId())) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkItemExist(ArrayList<Fruit> lo, String id) {
        for (Fruit order : lo) {
            if (order.getFruitId().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }
}
