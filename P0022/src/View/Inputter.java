
package View;

import java.util.Scanner;

public class Inputter {
    Scanner sc = new Scanner(System.in);
    public String inputStr(){
        return sc.nextLine();
    }
    public void display(String mess){
        System.out.print(mess);
    }
}
