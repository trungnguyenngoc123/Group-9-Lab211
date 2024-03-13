
package Common;

import java.util.Scanner;

public class Library {
    private Scanner sc = new Scanner(System.in);
    public String inputStr(String mess){
        System.out.println(mess);
        return sc.nextLine();
    }
}
