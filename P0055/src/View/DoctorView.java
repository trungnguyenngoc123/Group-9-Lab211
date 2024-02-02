package View;

import Model.Doctor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class DoctorView {

    public void displayMess(String mess) {
        System.out.println(mess);
    }

    public void display(HashMap<String, Doctor> searchFounded) {
        System.out.println("---------------------------RESULT--------------------------------------");
        if (searchFounded.isEmpty()) {
            System.out.println("Doctor does not exist!");
        } else {
            List<Doctor> sortedDoctors = new ArrayList<>(searchFounded.values());
            Collections.sort(sortedDoctors, Comparator.comparing(Doctor::getCode));
            System.out.printf("%-7s %-20s %-20s %-13s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : sortedDoctors) {
                doctor.displayInfo();
            }
        }
    }
}
