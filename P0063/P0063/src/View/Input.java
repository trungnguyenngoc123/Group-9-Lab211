
package View;

import Validate.Validation;
import java.util.Scanner;

/**
 *
 * @author MINH CHIEN
 */
public class Input {
    Validation validate = new Validation();
    
    private  final Scanner scanner = new Scanner(System.in);
    View view = new View();
    public String getInputString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
public  double getDouble(String prompt) {                        
        while (true) {
            try {     
                double salary;          
                  view.displayInput(prompt);
                salary = scanner.nextDouble();
                if (validate.checkInputNumber(salary)) {
                    return salary;  
                } else {
                    view.displayMess("Salary must be greater than 0.");
                }
            } catch (NumberFormatException e) {
                view.displayMess("Please enter a number ");
            }
        }
    }
            }
        
       
    


