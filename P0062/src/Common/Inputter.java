
package Common;

import View.View;
import java.util.Scanner;

public class Inputter {
    View view = new View();
    Scanner sc = new Scanner(System.in);
    public String inputStr(String mess){
        view.displayToInput(mess);
        return sc.nextLine();
    }
}
