package Controller;

import Utility.Manager;
import View.Menu;


public class Control extends Menu{
  
   Manager ag = new Manager();
    public Control() {
     super("File processing", new String[]{"Find person infor","Copy file text to new file", "Exit"});
        

    }

   @Override
    public void execute(int ch) {         
        switch (ch) {
            case 1:
                ag.getPerson();
                break;

            case 2:   
                ag.copyText();
                break;

            case 3:
                System.exit(0);
                break;
        }
    }
}
