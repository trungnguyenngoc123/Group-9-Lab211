package View;

import java.util.Scanner;

public class Validation {

    public static int checkInputPositiveInt() {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                int result = sc.nextInt();
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.print("Wrong number format please enter a positive number: ");
            }
        } while (true);
    }

    public static int checkInputInt() {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.print("\nWrong number format, please enter again: ");
            }
        } while (true);
    }

}
