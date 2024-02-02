package library;

import java.util.Scanner;
import library.Calculator.Operator;
import View.Input;

public class Validation {
    Input input = new Input();
    Scanner sc = new Scanner (System.in);
    public Operator checkOp(String operator) {
        switch (operator) {
            case "+":
                return Operator.ADD;
            case "-":
                return Operator.SUBTRACT;
            case "*":
                return Operator.MULTIPLY;
            case "/":
                return Operator.DIVIDE;
            case "^":
                return Operator.EXPONENT;
            case "=":
                return Operator.EQUAL;
            default:
                System.out.println("Please input (+, -, *, /, ^)");
                return checkOp(input.inputOP());
        }
    }
}
