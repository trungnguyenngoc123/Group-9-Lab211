package Controller;

import Common.Common;
import Common.Manage;
import View.Menu;

public class Control extends Menu {

    final Manage mng = new Manage();
    final Common cm = new Common();
    private final String filename= cm.File ;

    public Control() {
        super("\nDictionary", new String[] {"Add word", "Delete word", "Translate word", "Exit"});
    }
    @Override
    public void execute(int choice) {
        mng.readFile(filename); 
        switch (choice) {
            case 1:
                mng.addWord();
                mng.writeFile(filename);
                break;
            case 2: 
                mng.deleteWord();
                mng.writeFile(filename);
                break;
            case 3:
                mng.translateWord();
                break;
            case 4:
                System.exit(0);
        }
    }
}
