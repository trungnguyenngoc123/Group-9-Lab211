
package Common;

import View.TaskView;
import View.TaskView;
import java.util.Scanner;

public class Library {
    TaskView view = new TaskView();
    protected Scanner sc;

    public Library() {
        sc = new Scanner(System.in);
    }
    public String inputStr(String mess){
        view.displayToInput(mess);
        return sc.nextLine();
    }
}
