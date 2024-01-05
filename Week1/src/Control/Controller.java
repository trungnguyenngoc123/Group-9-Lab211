package Control;

import Model.Model;
import View.Menu;
import View.Validation;

public class Controller extends Menu {

    public Controller() {
        super("\nSORT AND SEARCH SYSTEM", new String[]{"Sort array", "Search array", "Exit"});
    }
    @Override
    public void execute(int ch) {
        Controller mg = new Controller();
        int choice = 0;
        switch(ch){
            case 1:
                mg.sortOption();
                break;
            case 2:
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
    public void sortOption(){
        System.out.print("\nSORT SYSTEM");
        System.out.print("\n1.Bubble sort");
        System.out.print("\n2.Quick sort");
        System.out.print("\n3.Back");
        System.out.print("\nEnter your choice: ");
        int choice = Validation.checkInputPositiveInt();
        do{
        Manager mg = new Manager();
        switch(choice){
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
                break;
            }
        }while(choice > 1 && choice < 3);
    }
    public void searchOption(){
        System.out.print("\nSEARCH SYSTEM");
        System.out.print("\n1.Binary search");
        System.out.print("\n2.Linear search");
        System.out.print("\n3.Back");
        System.out.print("\nEnter your choice: ");
        int choice = Validation.checkInputPositiveInt();
        do{
        Manager mg = new Manager();
        switch(choice){
            case 1:
                
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
                break;
            }
        }while(choice > 1 && choice < 3);
    }
}
