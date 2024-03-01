package Common;

import View.View;

public class Validation {

    View view = new View();
    Inputter input = new Inputter();
    
    public String checkInputString(String mess) {
        while (true) {
            String result = input.inputStr(mess).trim();
            if (result.length() == 0) {
                view.displayMess("Not empty.");
            } else if (!result.matches("^[a-zA-Z]:\\\\(?:[^\\\\\\/:*?\"<>|\\r\\n]+\\\\)*[^\\\\\\/:*?\"<>|\\r\\n]*$")) {
                view.displayMess("Invalid path format. Please enter a valid file path.");
            } else {
                return result;
            }
        }
    }
    
}
