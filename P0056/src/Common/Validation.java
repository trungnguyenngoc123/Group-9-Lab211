package Common;

import Model.Worker;
import View.Inputter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

public class Validation {

    Inputter input = new Inputter();

    public String getID(String mess) throws Exception {
       
        String id = input.inputStr(mess);
        if (id.isEmpty()) {
            throw new Exception("Empty input!");
        }
        String regex = ("[Ww]\\s+\\d+");
        if (!id.matches(regex)) {
            throw new Exception("Invalid Code()\nExample: W 1 or w 1.");
        }
        return id.toUpperCase();
    }

    public double getWorkerSalary(String mess) throws Exception {
        double salary;
        try {
            salary = Double.parseDouble(input.inputStr(mess));
        } catch (Exception e) {
            throw new Exception("Please enter number\n");
        }
        if (salary <= 0) {
            throw new Exception("Salary must greater than 0\n");
        }
        return salary;
    }

    public int getWorkerBirth(String mess) throws Exception {
        int birthYear, age;
        try {
            birthYear = Integer.parseInt(input.inputStr(mess));
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            age = currentYear - birthYear;
        } catch (NumberFormatException e) {
            throw new Exception("Please enter number!\n");
        }
        if (age < 18 || age > 50) {
            throw new Exception("Age must be in range 18 to 50\n");
        }
        return age;
    }

    public String isCodeExist(ArrayList<Worker> list, String id) throws Exception {
        for (Worker c : list) {
            if (c != null && c.getId().toLowerCase().equals(id.toLowerCase())) {
                throw new Exception("Code is already existed in the list");
            }
        }
        return id;
    }

    public Worker findWorker(ArrayList<Worker> list, String code) {
        for (Worker x : list) {
            if (x.getId().equals(code)) {
                return x;
            }
        }
        System.out.println("Not found!");
        return null;
    }

    public String getNonBlankStr(String msg) throws Exception {
        String str = input.inputStr(msg);
        String regex = ("^" + "\\s*" + "([A-Za-z]+\\s?)*" + "\\s*" + "$");
        if (str.isEmpty()) {
            throw new Exception("Empty input!\n");
        }
        if (!str.matches(regex)) {
            throw new Exception("Please input text!\n");
        }
        return capitalWord(str);
    }

    public String capitalFirstChar(String str) {
        if (str.isEmpty() || str == null) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);

    }

    public String capitalWord(String str) {
        StringTokenizer stk = new StringTokenizer(str, " ");
        String result = capitalFirstChar(stk.nextToken().toLowerCase());
        while (stk.hasMoreElements()) {
            result += " " + capitalFirstChar(stk.nextToken().toLowerCase());
        }
        return result;
    }

    public String getDate() {
        String date;
        LocalDate ld = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        date = ld.format(formatter);
        return date;
    }

}
