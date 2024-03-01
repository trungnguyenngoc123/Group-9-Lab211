package Controller;

import Utility.Manager;
import View.Menu;




public class Control extends Menu{
  Manager mg = new Manager();

    public Control() {
     super("Management Person Program", new String[]{"Input information ","Show 3 persons information","Exit"});
        

    }

   @Override
    public void execute(int ch) {         
        switch (ch) {
            case 1:
               mg.inputPersonInfor();
                break;

            case 2:   
               mg.displayPersonInfor();
                break;

            case 3:
                System.exit(0);
                break;
        }
    }
}
