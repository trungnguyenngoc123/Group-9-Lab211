package Controller;

import Common.Inputter;
import Model.ValidateModel;
import View.Menu;
import View.View;

public class Control extends Menu {

    Inputter input = new Inputter();
    ValidateModel model;
    View view = new View();
    public Control() {
        super("Validate Progaram ", new String[]{"Check Data Format", "Display data Format", "Exit"});
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                model = input.inputData();
                break;
            case 2:
                view.display(model);
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
}
