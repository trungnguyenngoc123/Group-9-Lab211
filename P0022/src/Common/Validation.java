package Common;

import Model.Candidate;
import View.Inputter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Validation {

    Inputter input = new Inputter();
    public String checkBirthDay() {
        while (true) {
            String result = input.inputStr().trim();
            String regex = "^[0-9]{4}$";
            if (result.matches(regex)) {
                int birthYear = Integer.parseInt(result);
                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                int age = currentYear - birthYear;
                if (birthYear < currentYear && age >= 18 && age <= 60) {
                    return result;
                } else {
                    System.err.println("Invalid input. Birth year cannot be in current or the future and age is from 18 to 60.");
                    input.display("Enter again: ");
                }
            } else {
                System.err.println("Invalid input. Please enter a valid birth year with a length of 4 digits.");
                input.display("Enter again: ");
            }
        }
    }

    public String checkGraduationTime(String birthDate) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            try {
                Date date = df.parse(input.inputStr());
                int graduationYear = getYear(date);//true
                int birth = Integer.parseInt(birthDate);
                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                int ageAfterSchool = graduationYear - birth;
                if (graduationYear <= birth || ageAfterSchool <= 17 || graduationYear > currentYear) {
                    throw new ParseException("", 0);
                } else {
                    return df.format(date);
                }
            } catch (ParseException e) {
                System.out.println("Graduation year must be smaller than current year and it must be after the birth year or age when you graduate must larger than 17 !");
                input.display("Invalid input, please enter again with format(dd/MM/yyyy): ");

            }
        }
    }

    public int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public String checkPhone() {
        while (true) {
            String result = input.inputStr().trim();
            String regex = "^[0-9]{10,}$";
            if (result.matches(regex)) {
                return result;
            } else {
                System.err.println("Invalid input. Please enter a valid phone number is number with minimum 10 characters.");
                input.display("Enter again: ");
            }
        }
    }

    public String checkEmail() {
        while (true) {
            String result = input.inputStr().trim();
            String regex = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";
            if (result.matches(regex)) {
                return result;
            } else {
                System.err.println("Invalid input. Please enter a valid email with format <account name>@<domain>.<Top-level Domains>. ");
                input.display("Enter again: ");
            }
        }
    }

    public String checkExperienceYear(String birthDate) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int birth = Integer.parseInt(birthDate);
        int age = currentYear - birth;
        while (true) {
            String result = input.inputStr().trim();
            String regex = "^[0-9]{0,100}$";
            int newResult = Integer.parseInt(result);
            if (result.matches(regex) && newResult < age) {
                return result;
            } else {
                System.out.println("Invalid input. Please enter a valid Year of Experience is number from 0 to 100 and must be smaller than age.");
                input.display("Enter again: ");
            }
        }
    }

    public String checkInputString() {
        while (true) {
            String result = input.inputStr().trim();
            if (result.isEmpty()) {
                System.out.print("Not empty, enter again: ");
            } else {
                return result;
            }
        }
    }

    public boolean checkInputYN() {
        while (true) {
            try {
                String result = checkInputString();
                if (result.equalsIgnoreCase("Y")) {
                    return true;
                } else if (result.equalsIgnoreCase("N")) {
                    return false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please input y/Y or n/N.");
                input.display("Enter again: ");
            }
        }
    }

    public boolean checkIdExist(ArrayList<Candidate> ls, String id) {
        for (Candidate cd : ls) {
            if (id.equalsIgnoreCase(cd.getcandidateID())) {
                return false;
            }
        }
        return true;
    }

    public String checkInputName() {
        while (true) {
            String result = input.inputStr().trim();
            String regex = "^[a-zA-Z\\s'-]+$";
            if (result.matches(regex) && result.length() >= 2) {
                result = result.substring(0, 1).toUpperCase() + result.substring(1).toLowerCase();
                return result;
            } else {
                System.err.println("Invalid input. Please enter a valid name without number and at least two characters.");
                input.display("Enter again: ");
            }
        }
    }
}
