
package Utility;

import Model.Person;
import View.Input;
import View.View;


public class Manager {  
    Input input = new Input();
    View view = new View();
    Person[] person;
    public Manager() {
        person = new Person[3];
    }
        public Person inputPersonInfo(String name, String address, double salary) {
        Person person = new Person(name, address, salary);
        return person;
    }
    public void inputPersonInfor(){
   for(int i=0;i<3;i++){
       String name = input.getInputString("Enter Name: ");
       String address = input.getInputString("Enter address: ");
       double salary = input.getDouble("Enter salary: ");
       person[i] = inputPersonInfo(name, address, salary);
   }
    }
     
      public void sort() {  
        try {
            sortBySalary(this.person);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
        
     Person[] sortBySalary(Person[] person) throws Exception {
        if (person.length == 0) {
            throw new Exception("No information to display!");
        }
        if (person == null) {
            throw new Exception("Can not sort and display null list");
        }
        for (int i = 0; i < 3-1; i++) {
            for (int j = 0; j < 3 - i - 1; j++) {
                if (person[j].getSalary() > person[j+1].getSalary()) {
                    Person temp = person[j];
                    person[j] = person[j+1];
                    person[j+1] = temp;
                }
            }
        }
        return person;
    }
  public void displayPersonInfor() {
        sort();
        for(int i = 0 ; i< 3 ; i++){
            displayPersonInfo(person[i]);
        }
    }

    
    public void displayPersonInfo(Person person) {
        view.displayMess("Information of Person you have entered:");
        view.displayMess("Name: " + person.getName());
        view.displayMess("Address: " + person.getAddress());
        view.displayMess("Salary: " + person.getSalary());
    }
}
