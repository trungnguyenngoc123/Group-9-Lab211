package Controller;

import Model.Fruit;
import View.Menu;
import java.util.ArrayList;

public class Controller extends Menu {
    private Manager mg;
    private ArrayList<Fruit> fruits;
    public Controller() {
        super("\nFRUIT SHOP SYSTEM", new String[]{"Create Fruit", "View Order", "Shopping(for buyer)", "Exit"});
        mg = new Manager();
        fruits = new ArrayList<>();
    }
    @Override
    public void execute(int ch) {         
        switch(ch){
            case 1:
                fruits = mg.createFruit();
                break;
            case 2:
                mg.viewOrder();
                break;
            case 3:
                if(!fruits.isEmpty()){
                    mg.shopping();
                }else{
                    System.out.println("Nothing in shop, can not buy");
                }
                break;
            case 4:
                System.exit(0);
                break;
        }
    }
    
}