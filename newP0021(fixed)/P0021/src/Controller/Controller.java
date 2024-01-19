package Controller;

import View.Menu;

public class Controller extends Menu {
    private Manager mg; 
    public Controller() {
        super("\nWELCOME TO STUDENT MANAGEMENT", new String[]{"Create", "Find and sort", "Update/Delete", "Report", "Exit"});
        mg = new Manager();
    }
    @Override
    public void execute(int ch) { 
        switch(ch){
            case 1:
                mg.generateStudent();
                mg.createStudent();
                break;
            case 2:
                mg.findAndSort();
                break;
            case 3:
                mg.updateOrDelete();
                break;
            case 4: 
                mg.report();
                break;
            case 5:
                System.exit(0);
                break;
        }
    }
    
}