package Common;

import View.View;
import java.util.Scanner;

public class Validation {

    View view = new View();
    Scanner sc = new Scanner(System.in);

    public String inputStr(String mess) {
        view.displayMessInput(mess);
        return sc.nextLine();
    }

    public String checkPhone(String phone) {
        boolean cont = true;
        while (cont) {
            if (!phone.matches("\\d{10}") && phone.matches("[0-9]+")) {
                System.out.println("Phone number must have 10 digits");
                phone = inputStr("Enter phone: ");
            } else if (!phone.matches("[0-9]+")) {
                System.out.println("Phone number shouldn't contain characters");
                phone = inputStr("Enter phone: ");
            } else {
                return phone;
            }
        }
        return phone;
    }

    public String checkDate(String date) {
        boolean cont = true;
        String regex = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/\\d{4}$";
        while (cont) {
            if (!date.matches(regex)) {
                view.displayMess("Date must be in correct format (dd/MM/yyyy)");
                date = inputStr("Enter Date: ");
            } else {
                return date;
            }
        }
        return date;
    }

    public String checkEmail(String email) {
        boolean cont = true;
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        while (cont) {
            if (!email.matches(regex)) {
                view.displayMess("Email must be correct format");
                email = inputStr("Enter Email: ");
            } else {
                return email;

            }
        }
        return email;
    }

}
