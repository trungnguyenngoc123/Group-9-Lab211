package Controller;

import Common.Library;
import Common.Validate;
import Model.BankModel;
import View.BankView;
import java.util.Random;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginSystem {

    private final String character = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private ResourceBundle lang;
    private String accountNumber, password;
    final BankModel bm = new BankModel();
    Library input = new Library();
    BankView view = new BankView();
    Validate validation;

    public LoginSystem() {
        validation = new Validate();
    }

    public String generateCaptcha() {
        Random rand = new Random();
        String res = "";
        do {
            int randValue = rand.nextInt(62);
            res = res + character.charAt(randValue);
        } while (res.length() < 6);
        return res;
    }

    public void login(Locale locate) {
        view.displayMess("---------- Login System ----------");
        lang = ResourceBundle.getBundle("Lang.lang", locate);
        this.accountNumber = validation.checkAccountNumber(input.inputStr(this.lang.getString("userMsg")), this.lang.getString("userMsg"), this.lang.getString("userErr"));
        bm.setAccount(this.accountNumber);
        this.password = validation.checkPassword(input.inputStr(this.lang.getString("passwordMSg")), this.lang.getString("passwordMSg"), this.lang.getString("passwordErr"));
        String captcha = generateCaptcha();
        view.displayMess(this.lang.getString("captcha")+ captcha);
        validation.checkCaptcha(input.inputStr(this.lang.getString("catpchaMsg")), captcha, this.lang.getString("catpchaerr"));

    }
}
