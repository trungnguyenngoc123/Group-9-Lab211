package Controller;

import Common.Validation;
import Model.Task;
import Utility.TaskManager;
import View.Menu;
import View.TaskView;
import java.util.ArrayList;

public class CCRMControl extends Menu {
    Validation vd = new Validation();
    TaskView view = new TaskView();
    ArrayList<Task> lt = new ArrayList<>();
    private TaskManager mg;
    private Task model = new Task();
    public CCRMControl() {
        super("Task program", new String[]{"Add Task", "Delete task", "Display Task", "Exit"});
        mg = new TaskManager();
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                try {
                    view.displayMess("------------Add Task---------------");
                    mg.addTask(model.getRequirementName(),
                            model.getTaskType(),
                            model.getDate(), model.getPlanFrom(), model.getPlanTo(), model.getassign(), model.getreviewer());
                } catch (Exception ex) {
                    view.displayMess(ex.getMessage());
                }
                
                break;
            case 2:
                view.displayMess("---------Del Task------");
                try {
                    mg.deleteTask(vd.checkInputString("Enter ID: "));
                } catch (Exception ex) {
                    ex.getMessage();
                }
                break;
            case 3:
                view.displayMess("----------------------------------------- Task ---------------------------------------");
                mg.getDataTask();
                break;
            case 4:
                System.exit(0);
                break;
        }
    }

}
