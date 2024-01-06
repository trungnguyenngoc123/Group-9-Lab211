package Control;

import Model.Model;
import View.Menu;

public class Controller extends Menu {

    public Controller() {
        super("\nSORT SYSTEM", new String[]{"Bubble sort", "Quick sort", "Exit"});
    }
    @Override
    public void execute(int ch) {
        Manager mg = new Manager();
        switch(ch){
            case 1:
                int size = mg.inputSizeOfArray();
                Model[] a = mg.inputValueOfArray(size);
                mg.sortArrayByBubbleSort(a);
                mg.print(a);
                break;
            case 2:
                int left = 0, right = 0;
                int m = mg.inputSizeOfArray2();
                Model[] b = mg.RandomValueOfArray(m);
                mg.partition(b, left, right);
                mg.quicksort(b, 0, m - 1);
                mg.print2(b);
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
    public void runner(){
        Controller manager = new Controller();
        manager.run();
    }
    
}
