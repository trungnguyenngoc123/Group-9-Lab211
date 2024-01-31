package Controller;

import Model.Model;
import View.Validation;
import java.util.Scanner;

public class Calculator {

    public enum Operator {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, EXPONENT, EQUAL, INVALID
    }

    public enum BMI {
        UNDERSTANDARD, STANDARD, OVERWEIGHT, FAT, VERYFAT
    }
    Validation vd = new Validation();
    Scanner sc = new Scanner(System.in);

    public double calculate(double a, Operator operator, double b) {
        switch (operator) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return a / b;
            case EXPONENT:
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    public void normalCalculator() {
        boolean check = false;
        double memory = 0;
        System.out.println("----- Normal Calculator -----");
        double a = vd.checkNum("Enter number: ");
        System.out.print("Enter operator: ");
        Operator operator = vd.checkOp(sc.nextLine());
        if (operator == Operator.EQUAL && check == false) {
            System.out.println("Result: No result");
            return;
        }
        double b = vd.checkNum("Enter number: ");
        Model model = new Model(a, b, operator, 0, 0, 0);
        memory = calculate(model.getNum(), model.getOp(), model.getMem());
        check = true;
        System.out.println("Memory: " + memory);
        do {
            System.out.print("Enter operator:");
            operator = vd.checkOp(sc.next());
            Model model1 = new Model(memory, 0, operator, 0, 0, 0);
            if (model1.getOp() == Operator.EQUAL && check == true) {
                System.out.println("Result: " + memory);
                return;
            }
            b = vd.checkNum("Enter number: ");
            Model model2 = new Model(memory, b, operator, 0, 0, 0);
            memory = calculate(model2.getNum(), model2.getOp(), model2.getMem());
            System.out.println("Memory: " + memory);
            if (operator == Operator.EQUAL) {
                System.out.println("Result: " + memory);
            }
        } while (model.getOp() != Operator.EQUAL);
    }

    public BMI calculateBMI(double weight, double height) {
        double bmi = weight / (Math.pow(height / 100, 2));
        if (bmi < 19) {
            return BMI.UNDERSTANDARD;
        } else if (bmi >= 19 && bmi <= 25) {
            return BMI.STANDARD;
        } else if (bmi > 25 && bmi <= 30) {
            return BMI.OVERWEIGHT;
        } else if (bmi > 30 && bmi <= 40) {
            return BMI.FAT;
        } else {
            return BMI.VERYFAT;
        }
    }

    public void bmiCalculator() {
        System.out.println("----- BMI Calculator -----");
        double weight = vd.checkNum("Enter weight(kg): ");
        double height = vd.checkNum("Enter height(cm): ");
        double bmi = weight / (Math.pow(height / 100, 2));
        Model model = new Model(0, 0, null, weight, height, bmi);
        System.out.printf("BMI number: %3.2f", model.getBMI());
        System.out.println("\nBMI Status: " + calculateBMI(weight, height));
    }
}
