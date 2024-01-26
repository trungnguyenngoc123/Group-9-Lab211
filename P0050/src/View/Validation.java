package View;

import java.util.ArrayList;
import java.util.Scanner;

public class Validation {

    public final Scanner sc = new Scanner(System.in);

    public float checkInputFloat(String mess) {
        System.out.print(mess);
        while (true) {
            try {
                float result = Float.parseFloat(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input, please input a number!");
                System.err.print("Enter again: ");
            }
        }
    }
    private boolean checkOdd(float n) {
        if (n % 2 == 1 || n % 1 != 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkEven(float n) {
        if (n % 2 == 0 && n % 1 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void printOdd(ArrayList<Float> myList) {
        String regex = "";
        System.out.print("Number is Odd: ");
        for (Float x : myList) {
            if (checkOdd(x)) {
                System.out.print(regex + x);
                regex = ", ";
            }
        }
        System.out.println();
    }

    public void printEven(ArrayList<Float> myList) {
        String regex = "";
        System.out.print("Number is Even: ");
        for (Float x : myList) {
            if (checkEven(x)) {
                System.out.print(regex + x);
                regex = ", ";
            }
        }
        System.out.println();
    }

    private boolean checkSquareNumber(Float n) {
        if (n >= 0) {
            int sr = (int) Math.sqrt(n);
            return (sr * sr == n);
        }
        return false;
    }

    public void printPerfectSquare(ArrayList<Float> myList) {
        String regex = "";
        System.out.print("Number is perfect square: ");
        for (Float x : myList) {
            if (checkSquareNumber(x)) {
                System.out.print(regex + x);
                regex = ", ";
            }
        }
        System.out.println();
    }
}
