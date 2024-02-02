
package Common;

import Model.Doctor;
import View.DoctorView;
import View.Inputter;
import java.util.HashMap;

public class DoctorManager {
    DoctorView view = new DoctorView();
    Inputter inputter = new Inputter();
    Validation vd = new Validation();
    private HashMap<String, Doctor> doctorMap = new HashMap<>();
    public void addDoctor(){
        view.displayMess("--------- Add Doctor ----------");
        String code, name, spec;
        int availability = 0;
        while (true) {
            try {
                code = vd.ifExistedCode(doctorMap, vd.checkCode());
                break;
            }
            catch (Exception e) {
                view.displayMess(e.getMessage());
            }        
        }
        while (true) {
            try {
                name = vd.getStr("Enter name: ");
                break;
            }catch(Exception e){
                view.displayMess("Empty, please enter again!");
            }
        }
        while (true) {
            try{
                spec = vd.getStr("Enter specialization: ");
                break;
            }catch(Exception e){
                view.displayMess(e.getMessage());
            }
        }
        while (true) {
            try{
                availability = inputter.checkAvailability();
                break;
            }catch(Exception e){
                view.displayMess(e.getMessage());
            }
        }
        try {
            addDoctor(new Doctor(code, name, spec, availability));
            view.displayMess("Doctor added successfully!");
        } catch (Exception e) {
            view.displayMess(e.getMessage());
        }
    }
    public boolean addDoctor (Doctor doctor) throws Exception{
        if (doctorMap == null) {
            throw new Exception("Database does not exit!");
        }      
        if (doctor == null) {
            throw new Exception("Data does not exist");
        }       
        doctorMap.put(doctor.getCode(), doctor);
        return true;
    }
    
    public boolean updateDoctor(Doctor doctor) throws Exception {
        view.displayMess("----------------------------UPDATE DOCTOR---------------------------");
        String name;
        String spec;
        int availability = 0;
        if(doctorMap.isEmpty()){
            throw new Exception("There is no doctor to update");
        }
        if (doctorMap == null) {
            throw new Exception("Database does not exit!");
        }     
        String code = vd.checkCode();
        if (!doctorMap.containsKey(code)) {
            throw new Exception("Doctor code doesn’t exist");
        }
        doctor = doctorMap.get(code);
        if (doctor == null) {
            throw new Exception("Data does not exist");
        }
        while (true) {
            try {
                name = vd.getStr("Enter name: ");
                break;
            } catch (Exception e) {
                view.displayMess(e.getMessage());
            }
        }

        while (true) {
            try {
                spec = vd.getStr("Enter specialization: ");
                break;
            } catch (Exception e) {
                view.displayMess(e.getMessage());
            }
        }

        while (true) {
            try {
                availability = inputter.checkAvailability();
                break;
            } catch (Exception e) {
                view.displayMess(e.getMessage());
            }
        }
        
        String newName = (name == null) ? doctor.getName():name;
        String newSpec = (spec == null)? doctor.getSpecialization():spec;
        int newAvailability = (availability == 0) ? doctor.getAvailability() : availability;        
        doctorMap.put(code, new Doctor(code,newName, newSpec, newAvailability));
        view.displayMess("Update successful!");
        return true;
    }
    public boolean deleteDoctor (Doctor doctor) throws Exception{
        view.displayMess("---------------------------------DELETE DOCTOR-------------------------");
        if (doctorMap == null) {
            throw new Exception("Database does not exit!");
        }
        
        if(doctorMap.isEmpty()){
            throw new Exception("There is no doctor to delete");
        }
        String code = vd.checkCode();
        if (!doctorMap.containsKey(code)) {
            throw new Exception("Doctor code doesn’t exist");
        }
        doctor = doctorMap.get(code);
        doctorMap.remove(code);
        view.displayMess("Deleted successful!");
        return true;
    }
    public void searchDoctor(){
        view.displayMess("-------------------------SEARCH DOCTOR--------------------------------");
        String input = inputter.inputStr("Enter text: ").toLowerCase();
        try {
            searchDoctor(input);
        } catch (Exception ex) {
            view.displayMess(ex.getMessage());
        }
    }
    public HashMap<String, Doctor> searchDoctor(String input) throws Exception {
        HashMap<String, Doctor> doctorFounded = new HashMap<String, Doctor>();
        if (doctorMap.isEmpty()) {
            throw new Exception("There are no doctor to search");
        }
        if (doctorMap == null) {
            throw new Exception("Database does not exist");
        }

        if (input.isEmpty()) {
            doctorFounded = doctorMap;
            view.display(doctorFounded);
            return doctorFounded;
        }else{
            for (Doctor doctor : doctorMap.values()) {
                if (doctor.getCode().toLowerCase().contains(input) 
                        || doctor.getName().toLowerCase().contains(input) 
                        || doctor.getSpecialization().toLowerCase().contains(input)) {
                    doctorFounded.put(doctor.getCode(), doctor);
                }
            }
            view.display(doctorFounded);
            return doctorFounded;
        }         
    }
    public void DoctorHash() {
        doctorMap = new HashMap();
        doctorMap.put("DOC 1", new Doctor("DOC 1", "Nghia", "orthodontic", 3));
        doctorMap.put("DOC 2", new Doctor("DOC 2", "Phuong", "Obstetrics", 2));
        doctorMap.put("DOC 3", new Doctor("DOC 3", "Lien", "Obstetrics", 1));
    }
    
}
