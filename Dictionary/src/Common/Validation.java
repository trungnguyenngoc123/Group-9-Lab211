package Common;

import View.Inputter;
import View.View;

public class Validation {
    View view = new View();   
    Inputter input1 = new Inputter();
    public String YorN(String ms) {
        while (true) {
            String input = input1.checkString(ms).toUpperCase();
            if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N")) {
                return input;
            }

            view.display("Invalid choice. Please enter Y or N: ");
        }
    }
}
