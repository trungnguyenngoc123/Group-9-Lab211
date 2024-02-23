package View;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static double getDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String userInput = scanner.nextLine();
                return Double.parseDouble(userInput);
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid numeric value.");
            }
        }
    }
}
