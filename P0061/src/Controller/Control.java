package Controller;

import Common.Calculate;
import Model.Circle;
import Model.Rectangle;
import Model.Triangle;
import View.Menu;


public class Control extends Menu {
    private Calculate mg;
    public Control() {
        super("Calculator Shape Program", new String[]{"Calculate rectangle", "Calculate Circle", "Calculate Triangle", "Exit"});
        mg = new Calculate();
    }
    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                Rectangle retangle = mg.inputRectangle();
                mg.displayRectan(retangle);
                break;
            case 2:
                Circle circle = mg.inputCircle();
                mg.displayCircle(circle);
                break;
            case 3:
                Triangle trigle = mg.inputTriangle();
                mg.displayTrian(trigle);
                break;
            case 4:
                System.exit(0);
                break;
        }
    }
}
