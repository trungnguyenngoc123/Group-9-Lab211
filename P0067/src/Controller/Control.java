package Controller;


import Common.Manager;
import View.Menu;




public class Control extends Menu{
 Manager mg = new Manager();

    public Control() {
     super("Analysis String program", new String[]{"Analysis String ","Exit"});
       

    }

   @Override
    public void execute(int ch) {         
        switch (ch) {
            case 1:
                mg.Analize();
                break;

            case 2:   
              System.exit(0);  
        }
    }
}
