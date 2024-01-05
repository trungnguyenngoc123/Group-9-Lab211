//ở trong code này đã sửa đổi từ array thành arrayList 
package ManagerVer2;

import Model.Model;
import View.Menu;
import java.util.ArrayList;


public class Controller extends Menu {

    public Controller() {
        super("\nSORT SYSTEM", new String[]{"Bubble sort", "Quick sort", "Exit"});
    }
    @Override
    public void execute(int ch) {
        Manager mg = new Manager();
        ArrayList<Model> models = new ArrayList<>();
        switch(ch){
            case 1:
                int size = mg.inputSizeOfArray();
                models = mg.inputValueOfArray(size);
                mg.sortArrayByBubbleSort(models);
                mg.print(models);
                break;
            case 2:
                int left = 0, right = 0;
                int m = mg.inputSizeOfArray2();
                models = mg.randomValueOfArray(m);
                mg.partition(models, left, right);
                mg.quicksort(models, 0, m - 1);
                mg.print2(models);
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
    public static void main(String[] args) {
        Controller manager = new Controller();
        manager.run();
    }
    
}

