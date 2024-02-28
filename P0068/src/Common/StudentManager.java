package Common;

import Model.Student;
import View.StudentView;
import java.util.Collections;
import java.util.List;

public class StudentManager {

    Validation vd = new Validation();
    StudentView view = new StudentView();

    public void sortStudent(List<Student> students) {
        while (true) {
            view.displayMess("Please input student information ");
            String name = vd.checkInputString("Name: ");
            String classes = vd.checkInputString("Classes: ");
            float mark = vd.checkInputFloat("Mark: ");
            students.add(new Student(name, classes, mark));
            if (!vd.checkInputYN("Do you want to enter more student information? (Y/N): ")) {
                break;
            }
        }
        if (students.isEmpty()) {
            view.displayMess("List is empty.");
            return;
        }
        Collections.sort(students);
    }

    public void display(List<Student> students) {
        view.displayMess("List after sort");
        for (int i = 0; i < students.size(); i++) {
            view.displayMess("--------Student " + (i + 1) + "--------");
            view.displayMess("Name: " + students.get(i).getName());
            view.displayMess("Classes: " + students.get(i).getClasses());
            view.displayMess("Mark: " + students.get(i).getMark());
        }
    }
}
