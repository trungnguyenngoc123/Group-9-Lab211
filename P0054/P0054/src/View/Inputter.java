
package View;

import java.util.Scanner;
public class Inputter {
    Scanner sc = new Scanner (System.in);
    public String inputStr(){
        return sc.nextLine();
    }
    public int inputID(String t) {
        System.out.print(t);
        while (true) {
            try {
                int id = Integer.parseInt(sc.nextLine());
                return id;
            } catch (Exception e) {
                System.out.println("ID is a digit!");
                System.out.print("Enter again: ");
            }
        }
    }
}
