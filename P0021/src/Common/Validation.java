package Common;

import Model.Student;
import Model.Report;
import View.Inputter;
import java.util.ArrayList;

public class Validation {

    Inputter input = new Inputter();

    public boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = input.checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.err.println("Please input y/Y or n/N.");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input u / d
    public boolean checkInputUD() {
        //loop until user input correct
        while (true) {
            String result = input.checkInputString();
            //return true if user input u/U
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            //return false if user input d/D
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }

    //check student exist
    public boolean checkStudentExist(ArrayList<Student> students, String id, String studentName, int semester, String courseName) {
        for (Student student : students) {
            if (id.equalsIgnoreCase(student.getId())
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester == student.getSemester()
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }

    //check report exist
    public boolean checkReportExist(ArrayList<Report> lr, String name,
            String course, int total) {
        for (Report report : lr) {
            if (name.equalsIgnoreCase(report.getStudentName())
                    && course.equalsIgnoreCase(report.getCourseName())
                    && total == report.getTotalCourse()) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIdExist(ArrayList<Student> ls, String id) {
        for (Student student : ls) {
            if (id.equalsIgnoreCase(student.getId())) {
                return false;
            }
        }
        return true;
    }

    public boolean checkChangeInfomation(Student student, String id,
            String name, int semester, String course) {
        if (id.equalsIgnoreCase(student.getId())
                && name.equalsIgnoreCase(student.getStudentName())
                && semester == student.getSemester()
                && course.equalsIgnoreCase(student.getCourseName())) {
            return false;
        }
        return true;
    }

}
