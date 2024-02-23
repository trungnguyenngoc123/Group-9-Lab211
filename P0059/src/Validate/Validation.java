package Validate;

import View.Input;

public class Validation {

    public String filePath() {
        String Path;
        while (true) {
            Path = Input.getInput("Enter path: ");
            if (Path.length() == 0) {
                System.out.println("Not empty!");
            } else if (!Path.matches("^[a-zA-Z]:\\\\(?:[^\\\\\\/:*?\"<>|\\r\\n]+\\\\)*[^\\\\\\/:*?\"<>|\\r\\n]*$")) {
                System.err.println("Invalid path format. Please enter a valid file path.");
            } else {
                break;
            }

        }
        return Path;
    }

    public double getMoney() {
        double Money;
        while (true) {
            Money = Input.getDouble("Enter money: ");
            if (Money < 0) {
                return 0;
            }
            break;
        }
        return Money;
    }

    public String fileDesti() {
        String Path;
        while (true) {
            Path = Input.getInput("Enter new file name: ");
            if (Path.length() == 0) {
                System.out.println("Not empty!");
            } else if (!Path.matches("^[a-zA-Z0-9]+\\.txt$")) {
                System.err.println("Invalid name. Please enter a valid file name.");
            } else {
                break;
            }
        }
        return Path;
    }
}
