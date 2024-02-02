
package View;

import java.util.Scanner;

public class Input {
    Scanner sc = new Scanner (System.in);
    public float checkNum(String mess){
        System.out.print(mess);
        while (true) {
            try{
                float result = Float.parseFloat(sc.nextLine());
                return result;
            }catch(NumberFormatException e){
                System.out.println("Please input a number!");
                System.out.print("Enter again: ");
            }
        }
    }
    public String inputOP(){
        System.out.print("Enter Operator: ");
        String operator = sc.nextLine();
        return operator;
    }
}
