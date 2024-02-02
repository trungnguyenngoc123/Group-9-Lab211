
package Model;

public class Student implements Comparable<Student> {
    private String id;
    private String studentName;
    private int semester;
    private String courseName;

    public Student() {
    }

    public Student(String id, String studentName, int semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    @Override
    public int compareTo(Student t){
        return t.studentName.compareTo(this.studentName);
    }    
    public String toString() {
        return String.format("%-15s%-15s%-15s\n", "Student name", "Semester", "Course Name") + 
                String.format("%-15s%-15s%-15s\n", studentName, semester, courseName);
    }
}
