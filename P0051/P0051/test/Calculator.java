
/*
import Controller.*;
import Model.Model;
import View.Menu;
import View.Validation;

public class Calculator extends Menu {

    Validation vd = new Validation();
    
    public void normalCal() {//done (test case not finish!)
        double num = vd.checkNum("Enter number: ");
        while (true) {
            Menu mn = new Menu("Operator", new String[]{"+", "-", "*"});
            mn.display();
            String operator = vd.checkOP("Enter operator: ");
            if (operator.equals("=")) {
                System.out.println("Result: " + num);
                break;
            }
            double mem = vd.checkNum("Enter number: ");
            Model model = new Model(num, mem, operator);
            num = model.getNum();
            mem = model.getMem();
            switch (model.getOp()) {
                case "+":
                    num += mem;
                    break;
                case "-":
                    num -= mem;
                    break;
                case "*":
                    num *= mem;
                    break;
                case "/":
                    double divisor = mem;
                    if (divisor != 0) {
                        num /= divisor;
                    } else {
                        System.out.println("Error: Division by zero.");
                    }
                    break;
                case "^":
                    num = Math.pow(num, mem);
                    break;
            }
            model.setNum(num);
            System.out.println("Memory: " + num);
        }
    }
    
}*/
