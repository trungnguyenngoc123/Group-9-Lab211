
package View;

import java.util.Scanner;

public class Inputter {
    Scanner sc = new Scanner(System.in);
    public String checkInputString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
    public int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range: [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    public int checkInputSemester() {
        while (true) {
            try {
                int result = sc.nextInt();
                sc.nextLine();
                if (result == 0) {
                    throw new Exception();
                }
                return result;
            } catch (Exception e) {
                System.out.println("Invalid input semester!");
                System.out.print("Enter again: ");
                sc.nextLine();
            }
        }
    }
    public String checkInputName() {
        while (true) {
            String result = sc.nextLine().trim();
            String regex = "^[a-zA-Z\\s'-]+$";
            if (result.matches(regex) && result.length() >= 2) {
                result = result.substring(0, 1).toUpperCase() + result.substring(1).toLowerCase();
                return result;
            } else {
                System.err.println("Invalid input. Please enter a valid name without number and at least two character.");
                System.out.print("Enter again: ");
            }
        }
    }
    public String checkInputId() {
        while (true) {
            String result = sc.nextLine().trim();
            String regex = "^[a-zA-Z0-9\\s'-]+$";
            if (result.matches(regex)) {
                result = result.toUpperCase();
                return result;
            } else {
                System.err.println("Invalid input. Please enter a valid ID.");
                System.out.print("Enter again: ");
            }
        }
    }
}
