
package View;

import Model.ValidateModel;

public class View {
    public void displayMess(String mess){
        System.out.println(mess);
    }
    public void displayMessInput(String mess){
        System.out.print(mess);
    }
    public void display(ValidateModel model) {
        System.out.println("\n-------Data Format-------");
        System.out.println("Phone: " + model.getPhone());
        System.out.println("Email: " + model.getEmail());
        System.out.println("Date: " + model.getDate());
    }
}
