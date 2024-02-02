package Controller;

import Library.Manager;
import Model.Contact;
import View.Menu;
import java.util.ArrayList;
import java.util.List;

public class Control extends Menu {

    private Manager mg;
    private List<Contact> list = new ArrayList<>();
    private Contact contact = new Contact();
    public Control() {
        super("========= Contact program =========", new String[]{"Add a Contact", "Display all Contact", "Delete a Contact", "Exit"});
        mg = new Manager(list);
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                mg.addContact(list, contact);
                break;
            case 2:
                mg.displayAll(list);
                break;
            case 3:
                mg.deleteContact(list, contact);
                break;
            case 4:
                System.exit(0);
                break;
        }
    }
}
