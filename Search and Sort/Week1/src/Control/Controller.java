package Control;


import Control.Manager;
import Model.Model;
import View.Menu;
import View.Validation;

public class Controller extends Menu {

    private Manager mg;
    private int size;
    private Model[] a;

    public Controller() {
        super("\nSORT AND SEARCH SYSTEM", new String[]{"Input array","Sort array", "Search array", "Exit"});
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                input();
                break;
            case 2:
                if(a != null){
                   sortOption();
                }
                else{
                    System.err.println("You should input array before sort it");
                    input();
                }
                break;
            case 3:
                if(a != null){
                   searchOption();
                }
                else{
                    System.err.println("You should input array before sort it");
                    input();
                }
                break;
            case 4:
                System.exit(0);
                break;
        }
    }
    public void runner(){
        Controller rn = new Controller();
        rn.run();
    }
    public void input() {
        size = mg.inputSizeOfArray();
        a = mg.inputValueOfArray(size);
    }

    public void sortOption() {
        int choice;
        do {
            System.out.print("\n----------------------");
            System.out.print("\nSORT SYSTEM");
            System.out.print("\n----------------------");
            System.out.print("\n1.Bubble sort");
            System.out.print("\n2.Quick sort");
            System.out.print("\n3.Back");
            System.out.print("\n----------------------");
            System.out.print("\nEnter your choice: ");
            choice = Validation.checkInputPositiveInt();
            switch (choice) {
                case 1:
                    Manager.sortArrayByBubbleSort(a);
                    Manager.print(a);
                    break;
                case 2:
                    Manager.quicksort(a, 0, size - 1);
                    Manager.print(a);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice < 1 || choice > 3);
    }

    public void searchOption() {
        int choice;
        do {
            System.out.print("\n----------------------");
            System.out.print("\nSEARCH SYSTEM");
            System.out.print("\n----------------------");
            System.out.print("\n1.Binary search");
            System.out.print("\n2.Linear search");
            System.out.print("\n3.Back");
            System.out.print("\n----------------------");
            System.out.print("\nEnter your choice: ");
            choice = Validation.checkInputPositiveInt();

            int target = 0;
            switch (choice) {
                case 1:
                    target = mg.inputIndexOfSearch();
                    int result = mg.binarySearch(a, target);
                    if (result == -1) {
                        System.out.println(target + " is not found");
                    } else {
                        System.out.println(target + " is found at index: " + result);
                    }
                    break;
                case 2:
                    Manager.linearSearch(a, target);
                    Manager.search(a);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice < 1 || choice > 3);
    }
}