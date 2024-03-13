package Utility;

import Common.Validation;
import Model.Task;
import View.Menu;
import View.TaskView;
import java.util.ArrayList;

public class TaskManager {

    Validation vd = new Validation();
    TaskView view = new TaskView();
    int id = 0;
    ArrayList<Task> lt = new ArrayList<>();

    public void addTask(String requirementName, String taskType, String date, String planFrom,
            String planTo, String assignee, String reviewer) throws Exception {
        requirementName = vd.checkInputString("Enter Requirement Name: ");
        Menu menu = new Menu("Task Type", new String[]{"Code", "Test", "Design", "Review"});
        menu.display();
        int taskTypeID;
        taskType = null;
        do{
            taskTypeID = vd.checkInputInt("Enter Task Type: ");
            switch (taskTypeID) {
                case 1:
                    taskType = "Code";
                    break;
                case 2:
                    taskType = "Test";
                    break;
                case 3:
                    taskType = "Design";
                    break;
                case 4:
                    taskType = "Review";
                    break;
                default:
                    view.displayMess("Invalid task type. Please enter a number from 1 to 4.");
            }
        }while(taskTypeID  < 1 || taskTypeID > 4);
        id++;
        date = vd.checkInputDate("Enter Date: ");
        planFrom = vd.checkInputPlan("Enter From: ");
        planTo = vd.checkInputPlan("Enter To: ");
        assignee = vd.checkInputString("Enter Assignee: ");
        reviewer = vd.checkInputString("Enter Reviewer: ");
        lt.add(new Task(id, taskType, requirementName, date, planFrom, planTo, assignee, reviewer));
        view.displayMess("Add Task Success.");
    }

    public void deleteTask(String Id) throws Exception{
        if (lt.isEmpty()) {
            view.displayMess("List empty");
            return;
        }
        int id = Integer.parseInt(Id);
        boolean found = false;
        for (int i = 0; i < lt.size(); i++) {
            if (lt.get(i).getId() == id) {
                lt.remove(i);
                id--;
                for (int v = id; v < lt.size(); v++) {
                    lt.get(v).setId(lt.get(v).getId() - 1);
                }
                
                view.displayMess("Delete success.");
                found = true;
                break;
            }
        }
        if (!found) {
            view.displayMess("Not found.");
            return;
        }

    }

    public ArrayList<Task> getDataTask() {
        if (lt.isEmpty()) {
            view.displayMess("List empty.");
            return new ArrayList<Task>();
        }
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (int i = 0; i < lt.size(); i++) {
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    lt.get(i).getId(),
                    lt.get(i).getRequirementName(),
                    lt.get(i).getTaskType(),
                    lt.get(i).getDate(),
                    Double.parseDouble(lt.get(i).getPlanTo()) - Double.parseDouble(lt.get(i).getPlanFrom()),
                    lt.get(i).getassign(),
                    lt.get(i).getreviewer()
            );
        }
        return lt;
    }
}
