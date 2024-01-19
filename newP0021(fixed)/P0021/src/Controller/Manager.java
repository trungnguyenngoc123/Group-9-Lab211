package Controller;

import View.Validation;
import Model.Report;
import Model.Student;
import java.util.ArrayList;
import java.util.Collections;

public class Manager {

    ArrayList<Student> students = new ArrayList<>();
    
    public void createStudent() {
        
        while (true) {
            String name;
            System.out.println("===========================");
            System.out.print("Enter id: ");
            String id = Validation.checkInputString();
            
            if (!Validation.checkIdExist(students, id)) {
                System.out.println("Id has exist student. Please update semester and course!");
                String existingName = getStudentNameById(id);
                System.out.print("Enter new semester: ");
                int semester = Validation.checkInputSemester();
                String course = displayCourseMenu();
                if (!Validation.checkStudentExist(students, id, existingName, semester, course)) {
                    System.out.println("Duplicate!");
                } else {
                    students.add(new Student(id, existingName, semester, course));
                    System.out.println("Add student success!");
                }
            } else {
                System.out.print("Enter name student: ");
                name = Validation.checkInputName();
                System.out.print("Enter semester: ");
                int semester = Validation.checkInputSemester();
                String course = displayCourseMenu();
                if (Validation.checkStudentExist(students, id, name, semester, course)) {
                    students.add(new Student(id, name, semester, course));
                    System.out.println("Add student success!");
                } else {
                    System.err.println("Duplicate!");
                }
            }

            if (students.size() >= 1) {
                System.out.print("Do you want to continue (Y/N): ");
                if (!Validation.checkInputYN()) {
                    break;
                }
            }
        }
    }
    
    public String displayCourseMenu() {
        System.out.println("\n====================");
        System.out.println("CHOOSE YOUR COURSE:");
        System.out.println("====================");
        System.out.println("1. Java");
        System.out.println("2. .Net");
        System.out.println("3. C/C++");
        System.out.print("Enter your choice: ");
        int choice = Validation.checkInputIntLimit(1, 3);
        switch (choice) {
            case 1:
                return "Java";
            case 2:
                return ".Net";
            case 3:
                return "C/C++";
            default:
                return "";
        }
    }
    public String getStudentNameById(String id) {
        for (Student student : students) {
            if (id.equalsIgnoreCase(student.getId())) {
                return student.getStudentName();
            }
        }
        return "";
    }

    public void findAndSort() {
        if (students.isEmpty()) {
            System.out.println("Empty List!");
            return;
        }
        System.out.print("Enter student name to search: ");
        String name = Validation.checkInputName();
        System.out.println("\nList of Students: ");
        Collections.sort(students);
        for (Student student : students) {
            if (student.getStudentName().equalsIgnoreCase(name)) {
                System.out.println(student.toString());
            }
        }
    }

    public void updateOrDelete() {
        if (students.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.print("Enter id: ");
        String id = Validation.checkInputString();
        ArrayList<Student> listStudentFindByName = getListStudentById(students, id);
        if (listStudentFindByName.isEmpty()) {
            System.err.println("Not found student.");
        } else {
            Student student = getStudentByListFound(listStudentFindByName);
            System.out.print("Do you want to update (U) or delete (D) student: ");
            if (Validation.checkInputUD()) {
                System.out.print("Enter name student: ");
                String newName = Validation.checkInputName();
                System.out.print("Enter semester: ");
                int newSemester = Validation.checkInputSemester();
                String newCourse = displayCourseMenu();
                if (!Validation.checkChangeInfomation(student, id, newName, newSemester, newCourse)) {
                    System.err.println("Nothing change.");
                }
                if (Validation.checkStudentExist(students, id, newName, newSemester, newCourse)) {
                    student.setStudentName(newName);
                    student.setSemester(newSemester);
                    student.setCourseName(newCourse);
                    System.err.println("Update success.");
                } else {
                    System.out.println("Duplicate!");
                }
            } else {
                students.remove(student);
                System.err.println("Delete success.");
            }
        }
    }

    public ArrayList<Student> getListStudentById(ArrayList<Student> students, String id) {
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : students) {
            if (id.equalsIgnoreCase(student.getId())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }
    public Student getStudentByListFound(ArrayList<Student> listStudentFindByName) {
        System.out.println("List student found: ");
        int count = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
                "semester", "Course Name");
        //display list student found
        for (Student student : listStudentFindByName) {
            System.out.printf("%-10d%-15s%-15s%-15s\n", count,
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        System.out.print("Enter number: ");
        int choice = Validation.checkInputIntLimit(1, listStudentFindByName.size());
        return listStudentFindByName.get(choice - 1);
    }
    public void report() {
        if (students.isEmpty()) {
            System.err.println("List empty.");
            return;
        }

        ArrayList<Report> lr = new ArrayList<>();
        for (Student currentStudent : students) {
            String courseName = currentStudent.getCourseName();
            String studentName = currentStudent.getStudentName();

            boolean reportExists = false;

            for (Report report : lr) {
                if (report.getStudentName().equalsIgnoreCase(studentName)
                        && report.getCourseName().equalsIgnoreCase(courseName)) {
                    report.setTotalCourse(report.getTotalCourse() + 1);
                    reportExists = true;
                    break;
                }
            }

            if (!reportExists) {
                lr.add(new Report(studentName, courseName, 1));
            }
        }

        System.out.printf("%-15s|%-10s|%-7s\n", "Student Name", "Course Name", "Total");
        for (Report report : lr) {
            System.out.printf("%-15s|%-10s|%-7d\n", report.getStudentName(), report.getCourseName(), report.getTotalCourse());
        }
    }
    public void generateStudent() {
        students.add(new Student("1", "Luan", 2, "Java"));
        students.add(new Student("2", "Long", 2, ".NET"));
        students.add(new Student("3", "Trung", 3, "C/C++"));
        students.add(new Student("4", "Hoang", 3, "Java"));
        students.add(new Student("5", "Van", 4, "Java"));
        students.add(new Student("6", "Toan", 2, "C/C++"));
        students.add(new Student("7", "Nam", 2, "Java"));
        students.add(new Student("8", "An", 3, ".NET"));
        students.add(new Student("9", "Nhan", 4, "Java"));
        students.add(new Student("10", "Anh", 3, "Java"));
    }
}