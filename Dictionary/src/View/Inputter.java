
package View;

import java.util.Scanner;

public class Inputter {
    Scanner sc = new Scanner (System.in);
    View view = new View();
    public String checkString(String ms) {
        view.displayToInput(ms);
        return sc.nextLine();
    }
}
