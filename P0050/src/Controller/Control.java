package Controller;

import Model.Model;
import View.Menu;
import View.Validation;
import java.util.ArrayList;

public class Control extends Menu {

    private Manager mg;
    private float a, b, c;
    private ArrayList<Float> myList = new ArrayList<>();
    private Validation vd = new Validation();

    public Control() {
        super("Equation Program", new String[]{"Calculate Superlative Equation", "Calculate Quadratic Equation", "Exit"});
        mg = new Manager();
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                myList = mg.calculateEquation(a, b);
                if (myList == null) {
                    System.out.println("Solution: no solution");
                } else if (myList.isEmpty()) {
                    System.out.println("Solution: infinitely many solutions");
                } else {
                    System.out.println("Solution: x = " + myList.get(2));
                    vd.printOdd(myList);
                    vd.printEven(myList);
                    vd.printPerfectSquare(myList);
                    System.out.println();
                }
                break;
            case 2:
                myList = mg.calculateQuadraticEquation(a, b, c);
                if (myList == null) {
                    System.out.println("Solution: no solution");
                } else if (myList.isEmpty()) {
                    System.out.println("Solution: infinitely many solutions");
                } else {
                    System.out.println("Solution: x1 = " + myList.get(3) + " and x2 = " + myList.get(4));
                    vd.printOdd(myList);
                    vd.printEven(myList);
                    vd.printPerfectSquare(myList);
                    System.out.println();
                }
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
}
