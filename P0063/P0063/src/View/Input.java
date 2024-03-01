package View;

import Validate.Validation;
import java.util.Scanner;

public class Input {

    Validation validate = new Validation();

    public final Scanner scanner = new Scanner(System.in);
    View view = new View();
public String getInputString(String prompt) {
    while (true) {
        
        view.displayInput(prompt);
        String input = scanner.nextLine();
        if (validate.isText(input)) {
            return validate.capitalizeWords(input);
        } else {
            view.displayMess("Please enter a valid text without numbers.");
        }
    }
}


    public double getDouble(String prompt) {
        while (true) {
            try {
                view.displayInput(prompt);
                String input = scanner.nextLine();
                double salary;               
                    salary = Double.parseDouble(input);
                    if (validate.isPositiveNumber(salary)) {
                        return salary;
                    } 
            } catch (NumberFormatException e) {
                view.displayMess("Please enter a valid number.");
            }
        }
    }
}


