
package Control;

import Model.Model;
import View.Menu;


public class Controller extends Menu {
    private Model content;
    public Controller() {
        super("\nCOUNT SYSTEM", new String[]{"Input String", "Count", "Exit"});
    }
    @Override
    public void execute(int ch) {
        Counter counter = new Counter();
        switch(ch){
            case 1:
                content = counter.inputter();
                break;
            case 2:
                if(content != null){
                    countMenu cm = new countMenu();
                    cm.run();
                }else{
                    System.out.println("You should input a String before count !");
                    content = counter.inputter();
                    countMenu cm = new countMenu();
                    cm.run();
                }
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice, please choice again !");
                break;
        }
    }
      class countMenu extends Menu {
        public countMenu(){
            super("\nCHOOSE COUNT TYPE", new String[]{"Count word", "Count character", "Back"});
        }
        @Override
        public void execute(int ch){
            Counter ct = new Counter();
            switch(ch){
                case 1:
                    ct.analyze(content);
                    ct.displayWordCounter();
                    break;
                case 2:
                    ct.analyze(content);
                    ct.displayCharCounter();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice, please choice again !");
                    break;
            }
        }
    }
}
