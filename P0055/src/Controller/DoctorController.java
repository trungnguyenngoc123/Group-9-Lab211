package Controller;

import Model.Doctor;
import Common.DoctorManager;
import View.Menu;
import View.DoctorView;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoctorController extends Menu {

    private DoctorManager mg;
    private Doctor doctor;
    private DoctorView view = new DoctorView();

    public DoctorController() {
        super(" DOCTOR MANAGEMENT", new String[]{"Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Exit"});
        mg = new DoctorManager();
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                mg.DoctorHash();
                mg.addDoctor();
                break;
            case 2:
                try {
                    mg.updateDoctor(doctor);
                } catch (Exception e) {
                    view.displayMess(e.getMessage());
                }
                break;
            case 3:
                try {
                    mg.deleteDoctor(doctor);
                } catch (Exception e) {
                    view.displayMess(e.getMessage());
                }
                break;
            case 4:
                mg.searchDoctor();
                break;
            case 5:
                System.exit(0);
                break;
        }
    }
}
