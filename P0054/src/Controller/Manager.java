package Controller;

import Model.Contact;
import View.Validation;
import java.util.List;
import java.util.StringTokenizer;

public class Manager {

    Validation vd = new Validation();
    
    private List<Contact> list;
    public Manager(List<Contact> list){
        this.list = list;
    }
    int id = 1;
    public boolean addContact(List<Contact> list, Contact contact) {
        System.out.println("-------- Add a Contact --------");
        String fullName = vd.getStr("Enter Name: ");
        StringTokenizer st = new StringTokenizer(fullName, " ");
        String lastName = "";
        String firstName = st.nextToken();
        while (st.hasMoreElements()) {
            lastName += st.nextToken() + " ";
        }
        String group = vd.getStr("Enter group: ");
        String address = vd.getNonBlankStr("Enter address: ");
        String phone = vd.inputPhone("Enter phone number: ");
        System.out.println("Successful");
        contact = new Contact(id, fullName, group, address, phone, lastName, firstName);
        id++;
        return list.add(contact);
    }

    public void displayAll(List<Contact> list) {
        if (list.isEmpty()) {
            System.out.println("There are no contact to display");
            return;
        }
        System.out.println("--------------------------------- Display all Contact ----------------------------");
        System.out.printf("%-15s %-15s %-15s %-20s %-8s %-15s %-10s\n", "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
        for (Contact x : list) {
            x.display();
        }
    }

    public boolean deleteContact(List<Contact> list, Contact contact) {
        System.out.println("-------- Delete a Contact --------");
        int ID = vd.inputID("Enter ID to delete: ");
        contact = vd.checkExistContact(list, ID);
        System.out.println("Successful");
        return list.remove(contact);
    }
}
