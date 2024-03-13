
package Controller;


import View.Menu;
import View.BankView;
import java.util.ArrayList;
import java.util.Locale;


public class TPBankControl extends Menu {

    private LoginSystem mg;
    private BankView view = new BankView();
    private ArrayList lt = new ArrayList<>();
    public TPBankControl () {
        super("Login Program", new String[]{"Vietnamese", "English", "Exit"});
        mg = new LoginSystem();
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                mg.login(new Locale("vi", "VN"));
                break;
            case 2:
                mg.login(new Locale("en", "US"));
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
    
}

