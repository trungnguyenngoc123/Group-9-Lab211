
package Common;

import View.StudentView;
import java.util.Scanner;

public class Inputter {
    Scanner sc = new Scanner (System.in);
    StudentView view = new StudentView();
    public String inputStr(String mess){
        view.displayToInput(mess);
        return sc.nextLine();
    } 
}
