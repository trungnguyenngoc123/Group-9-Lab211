
package Controller;

import Common.StudentManager;
import View.Menu;
import View.StudentView;
import java.util.ArrayList;

public class StudentControl extends Menu {

    private StudentManager mg;
    private StudentView view = new StudentView();
    private ArrayList lt = new ArrayList<>();
    public StudentControl () {
        super("Collection Sort Program", new String[]{"Add Student and sort", "Display list student", "Exit"});
        mg = new StudentManager();
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                mg.sortStudent(lt);
                break;
            case 2:
                mg.display(lt);
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
    
}

