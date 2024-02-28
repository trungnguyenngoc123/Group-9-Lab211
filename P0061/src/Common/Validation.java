package Common;

import View.View;

public class Validation {

    Inputter input = new Inputter();
    View view = new View();
    public double checkInputDouble(String mess) {
        while (true) {
            try {
                System.out.print(mess);
                double result = Double.parseDouble(input.inputStr());
                if (result > 0) {
                    return result;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                view.displayMess("Invalid input, please input again!");
            }
        }
    }
}
