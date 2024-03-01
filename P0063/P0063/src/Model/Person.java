
package Model;

public class Person implements Comparable<Person> {
    private String name;
    private String address;
    private double salary;

     public Person() {
      
    }
     
    public Person(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
     @Override
    public int compareTo(Person o) {
        if(this.getSalary() < o.getSalary()) return -1;
        if(this.getSalary() > o.getSalary()) return 1;
        return 0;
    }
}
