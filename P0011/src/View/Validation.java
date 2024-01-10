package View;

import java.util.Scanner;

public class Validation {
    public static final Scanner sc = new Scanner(System.in);
    public static String checkInputBinary(){
        while(true){
            String result = sc.nextLine().trim();
            String regex = "^[0-1]+$";
            if(result.matches(regex)){
                return result;
            }else{
                System.err.println("Invalid input. Please enter a valid binary number!");
                System.out.print("Enter again: ");
            }
        }
    }
    public static int checkInputDecimal() {
        do {
            try {
                int result = sc.nextInt();
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Wrong number format please enter a decimal number!");
                System.out.print("Enter again: ");
            }
        } while (true);
    }

    public static String checkInputHex() {
        while(true){
            String result = sc.nextLine().trim();
            String regex = "^[0-9A-Fa-f]+$";
            if(result.matches(regex)){
                return result;
            }else{
                System.err.println("Invalid input. Please enter a valid hexadecimal number!");
                System.out.print("Enter again: ");
            }
        }
    }
    
}
