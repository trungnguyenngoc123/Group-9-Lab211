package Controller;

import Model.Fruit;
import View.Validation;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class Manager {
    ArrayList<Fruit> fruits = new ArrayList<>();
    Hashtable<String, ArrayList<Fruit>> orders = new Hashtable<>();
    public ArrayList<Fruit> createFruit(){
        while(true){
            System.out.print("Enter fruit id: ");
            String id = Validation.checkInputString();
            if(!Validation.checkIdExist(fruits, id)){
                System.err.println("Id exist!");
                System.out.print("Enter fruit id again: ");
                id = Validation.checkInputString();
            }
            System.out.print("Enter fruit name: ");
            String fruitName = Validation.checkInputName();
            System.out.print("Enter price: ");
            double price = Validation.checkInputDouble();
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputInt();
            System.out.print("Enter origin: ");
            String origin = Validation.checkInputString();
            fruits.add(new Fruit(id, fruitName, price, quantity, origin));
            System.err.println("Create success!");
            System.out.println("============================");
            System.err.print("Do you want to continue(Y/N): ");
            if(!Validation.checkInputYN()){
                return fruits;
            }
        }
        
    }
 public void viewOrder() {
    if (orders.isEmpty()) {
        System.out.println("No orders");
        return;
    }
    for (Map.Entry<String, ArrayList<Fruit>> entry : orders.entrySet()) {
        String customerName = entry.getKey();
        ArrayList<Fruit> orderFruits = entry.getValue();

        System.out.println("Customer: " + customerName);
        displayListOrder(orderFruits);                  
    }
}

public void displayListOrder(ArrayList<Fruit> orderFruits) {
    double total = 0;
    System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
    for (Fruit order : orderFruits) {
        System.out.printf("%15s%15d%15.0f$%15.0f$\n", order.getFruitName(),
                order.getQuantity(), order.getPrice(),
                order.getPrice() * order.getQuantity());
        total += order.getPrice() * order.getQuantity();
    }

    System.out.println("Total: " + total);
}

public void shopping() {
  
    ArrayList<Fruit> orderFruits = new ArrayList<>();
    while (true) {
        ArrayList<Fruit> displayedFruits = displayListFruit();
    if (displayedFruits == null){
        System.out.println("Auto print out order!");
        System.out.print("Enter name: ");
        String name = Validation.checkInputString();
        orders.put(name, orderFruits);
        return;
    }
        System.out.print("Enter item: ");
        int item = Validation.checkInputIntLimit(1, fruits.size());
        Fruit selectedFruit = getFruitByItem(fruits, item); 
        System.out.print("Enter quantity: ");
        int quantity = Validation.checkInputIntLimit(1, selectedFruit.getQuantity());
        updateOrder(orderFruits, selectedFruit.getFruitId(), quantity);                            
        System.err.println("Add successful");
        System.out.print("Do you want to order now (Y/N): ");
        if (Validation.checkInputYN()) {           
                displayListOrder(orderFruits);
                System.out.print("Enter name: ");
                String name = Validation.checkInputString();
                orders.put(name, orderFruits);                
            break;
        }
        
        if (orderFruits.isEmpty()) {
        System.out.println("Empty list. All items are out of stock.");  
        break;
    }
    }
     
}

  public ArrayList<Fruit> displayListFruit() {
    int countItem = 1;
    if (fruits.isEmpty() || fruits.stream().allMatch(fruit -> fruit.getQuantity() == 0)) {
        System.out.println("Empty list. All items are out of stock.");
        return null;  
    }
    System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit name", "Origin", "Price", "Quantity");    
    ArrayList<Fruit> displayedFruits = new ArrayList<>();
    for (Fruit fruit : fruits) {
        if (fruit.getQuantity() != 0) {
            displayedFruits.add(fruit);
            System.out.printf("%-10d%-20s%-20s%-1.0f$\n", countItem++,
                    fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice(), fruit.getQuantity());
        }
    }

    return displayedFruits;
}


    private Fruit getFruitById(ArrayList<Fruit> fruitList, String id) {
    for (Fruit fruit : fruitList) {
        if (fruit.getFruitId().equalsIgnoreCase(id)) {
            return fruit;
        }
    }
    return null;
}
    public Fruit getFruitByItem(ArrayList<Fruit> lf, int item) {
        int countItem = 0;
        for (Fruit fruit : lf) {
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            if (countItem  == item) {
                return fruit;
            }
        }
        return null;
    }
 public void updateOrder(ArrayList<Fruit> orderFruits, String id, int quantity) {
    Fruit orderedFruit = getFruitById(fruits, id);

    if (orderedFruit != null) {
        int currentStock = orderedFruit.getQuantity();      
        int newQuantity = quantity; 
        if (newQuantity <= currentStock) {
            orderedFruit.setQuantity(currentStock - newQuantity);   
            boolean isAdded = false;
            for (Fruit order : orderFruits) {
                if (order.getFruitId().equalsIgnoreCase(id)) {
                    order.setQuantity(order.getQuantity() + newQuantity);
                    isAdded = true;
                    break;
                }
            }         
            if (!isAdded) {        
                Fruit newOrderItem = new Fruit(
                        orderedFruit.getFruitId(),
                        orderedFruit.getFruitName(),
                        orderedFruit.getPrice(),
                        newQuantity,
                        orderedFruit.getOrigin()
                );
                orderFruits.add(newOrderItem);
            }
        } else {
            System.out.println("Not enough stock for this item.");
        }
    }
}


}