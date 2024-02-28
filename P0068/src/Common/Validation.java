package Common;

import View.Inputter;
import View.StudentView;

public class Validation {
    Inputter input = new Inputter();
    StudentView sv = new StudentView();
    public String checkInputString(String mess) {
        while (true) {
            String result = input.inputStr(mess);
            if (result.length() == 0) {
                sv.displayMess("Not empty.");
            } else {
                return result;
            }
        }
    }

    public boolean checkInputYN(String mess) {
        while (true) {
            String result = input.inputStr(mess);
            if (result.length() == 1 && result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.length() == 1 && result.equalsIgnoreCase("N")) {
                return false;
            }
            sv.displayMess("Re-input.");
        }
    }

    public float checkInputFloat(String mess) {
        while (true) {
            try {
                float result = Float.parseFloat(input.inputStr(mess));
                return result;
            } catch (NumberFormatException ex) {
                sv.displayMess("Re-input");
            }
        }
    }
}
