package View;

import Validate.Validation;
import java.util.Scanner;

public class Input {

    Validation validate = new Validation();

    public final Scanner scanner = new Scanner(System.in);
    View view = new View();
public String getInputString(String prompt) {
        System.out.print(prompt);
        return validate.capitalizeWords(scanner.nextLine());
    }

    public double getDouble(String prompt) {
        while (true) {
            try {
                view.displayInput(prompt);
                String input = scanner.nextLine();
                double salary;

                if (validate.isInputNumber(input)) {
                    salary = Double.parseDouble(input);

                    if (validate.isPositiveNumber(salary)) {
                        return salary;
                    } else {
                        view.displayMess("Salary must be greater than 0.");
                    }
                } else {
                    view.displayMess("Please enter a valid number.");
                }
            } catch (NumberFormatException e) {
                view.displayMess("Please enter a valid number.");
            }
        }
    }
}

