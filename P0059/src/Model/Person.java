
package Model;


public class Person implements Comparable<Person> {
    String Name;
    String Address;
    double Salary;

    public Person(String Name, String Address, double Salary) {
        this.Name = Name;
        this.Address = Address;
        this.Salary = Salary;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }
  public void display(){
        System.out.printf("%-15s %-15s %6.1f\n",Name,Address,Salary);
    }

    @Override
    public int compareTo(Person o) {
       if(this.getSalary() < o.getSalary()) return -1;
        if(this.getSalary() > o.getSalary()) return 1;
        return 0;
    }
}
