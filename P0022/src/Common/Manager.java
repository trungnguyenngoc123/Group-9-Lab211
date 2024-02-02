package Common;

import Model.Candidate;
import Model.Experience;
import Model.Fresher;
import Model.Internship;
import View.Menu;
import java.util.ArrayList;

public class Manager {

    Validation vd = new Validation();
    public void createCandidate(ArrayList<Candidate> candidates, int candidateType) {
        while (true) {
            System.out.print("Enter Id: ");
            String candidateID = vd.checkInputString();
            if (vd.checkIdExist(candidates, candidateID)) {
                System.out.print("Enter first name: ");
                String firstName = vd.checkInputName();
                System.out.print("Enter last name: ");
                String lastName = vd.checkInputName();
                System.out.print("Enter year of birth: ");
                String birthDate = vd.checkBirthDay();
                System.out.print("Enter address: ");
                String address = vd.checkInputString();
                System.out.print("Enter phone: ");
                String phone = vd.checkPhone();
                System.out.print("Enter email: ");
                String email = vd.checkEmail();
                Candidate candidate = new Candidate(candidateID, firstName, lastName, birthDate, address, phone, email, candidateType);
                Manager mg = new Manager();
                switch (candidateType) {
                    case 1:
                        mg.createExperience(candidates, candidate);
                        break;
                    case 2:
                        mg.createFresher(candidates, candidate);
                        break;
                    case 3:
                        mg.createInternship(candidates, candidate);
                        break;
                }
            } else {
                System.out.println("Exist Id, please input Id again!");
                continue;
            }
            System.err.print("Do you want to continue(Y/N): ");
            if (!vd.checkInputYN()) {
                return;
            }
        }
    }
    public void createExperience(ArrayList<Candidate> candidates, Candidate candidate) {//create an object to invoke method from Candidate.java
        System.out.print("Enter year of experience: ");
        String yearExperience = vd.checkExperienceYear(candidate.getBirthDate());
        System.out.print("Enter professional skill: ");
        String professionalSkill = vd.checkInputString();
        candidates.add(new Experience(candidate.getcandidateID(), candidate.getFirstName(),
                candidate.getLastName(), candidate.getBirthDate(),
                candidate.getAddress(), candidate.getPhone(),
                candidate.getEmail(), candidate.getCandidateType(),
                yearExperience, professionalSkill));
        System.err.println("Create success !");
    }

    public void createFresher(ArrayList<Candidate> candidates, Candidate candidate) {//create an object to invoke method from Candidate.java
        
        System.out.print("Enter graduation time(dd/MM/yyyy): ");
        String graduationTime = vd.checkGraduationTime(candidate.getBirthDate());
        String graduationRank = displayGraduationMenu();
        System.out.print("Enter graduation school: ");
        String graduationSchool = vd.checkInputString();
        candidates.add(new Fresher(candidate.getcandidateID(), candidate.getFirstName(),
                candidate.getLastName(), candidate.getBirthDate(),
                candidate.getAddress(), candidate.getPhone(),
                candidate.getEmail(), candidate.getCandidateType(),
                graduationTime, graduationRank, graduationSchool));
        System.err.println("Create success !");
    }
    private String displayGraduationMenu(){
        Menu menu = new Menu("CHOOSE YOUR GRADUATION RANK", new String[]{"Excellence", "Good", "Fair", "Poor"});
        int graduationRank = menu.getSelected();
        switch (graduationRank) {
            case 1:
                return "Excellence";
            case 2:
                return "Good";
            case 3:
                return "Fair";
            case 4: 
                return "Poor";
            default:
                return "";
        }
    }
    public void createInternship(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter your major: ");
        String major = vd.checkInputString();
        System.out.print("Enter your semester: ");
        String semester = vd.checkInputString();
        System.out.print("Enter your University Name: ");
        String universityName = vd.checkInputString();
        candidates.add(new Internship(candidate.getcandidateID(), candidate.getFirstName(),
                candidate.getLastName(), candidate.getBirthDate(),
                candidate.getAddress(), candidate.getPhone(),
                candidate.getEmail(), candidate.getCandidateType(),
                major, semester, universityName));
        System.err.println("Create success !");
    }
    public void printAllList(ArrayList<Candidate> candidates) {
        
        boolean experienceFound = false;
        System.out.print("\n==========EXPERIENCE CANDIDATE=============\n");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
                experienceFound = true;
            }
        }
        if (!experienceFound) {
            System.out.println("Empty List");
        }
        
        boolean fresherFound = false;
        System.out.print("\n==========FRESHER CANDIDATE=============\n");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
                fresherFound = true;
            }
        }
        if (!fresherFound) {
            System.out.println("Empty List");
        }
        
        boolean internshipFound = false;
        System.out.print("\n==========INTERNSHIP CANDIDATE=============\n");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Internship) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
                internshipFound = true;
            }
        }
        if (!internshipFound) {
            System.out.println("Empty List");
        }
    }


   

  public void searchCandidate(ArrayList<Candidate> candidates) {
    printAllList(candidates);
    System.out.println("=======================");
    System.out.print("Enter candidate name (First name or Last name): ");
    String nameSearch = vd.checkInputName();
    int typeCandidate = 0;
    Menu menu = new Menu("===TYPE OF CANDIDATE===", new String[]{"Experience", "Fresher", "Internship"});
    typeCandidate = menu.getSelected();
    int count = 0;
    for (Candidate candidate : candidates) {
        
        if (candidate.getCandidateType() == typeCandidate
                && (candidate.getFirstName().toLowerCase().contains(nameSearch.toLowerCase()))
                || candidate.getLastName().toLowerCase().contains(nameSearch.toLowerCase())) {
            if(count == 0){
                System.out.println("The Candidate Found:");
            }
            System.out.println(candidate.toString());
            count++;
        }
        
    }
    if (count == 0) {
        System.out.println("Not found");
    }
}
}
