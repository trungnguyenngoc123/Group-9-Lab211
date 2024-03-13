package Common;

import Controller.LoginSystem;
import View.BankView;

public class Validate {

    Library input = new Library();

    public String checkAccountNumber(String accountNumber, String msg, String errMsg) {
        String regex = "^[\\d]{10}$";
        if (!accountNumber.matches(regex)) {
            System.out.println(errMsg);
            String newAccountNumber = input.inputStr(msg);
            return checkAccountNumber(newAccountNumber, msg, errMsg);
        }
        return accountNumber;
    }

    public String checkPassword(String password, String msg, String errMsg) {
        String regex = "^(?=.*[0-9])(?=.*[a-zA-Z])(?!.*\\s).{8,31}$";
        if (!password.matches(regex)) {
            System.out.println(errMsg);
            String newPassword = input.inputStr(msg);
            return checkPassword(newPassword, msg, errMsg);
        }
        return password;
    }

    public String checkCaptcha(String captchaInput, String captchaGenerate, String catpchaErr) {
        do {
            if (captchaInput.matches("^[0-9a-zA-Z]+$")) {
                if (captchaGenerate.contains(captchaInput)) {
                    return captchaInput;
                } else {
                    System.out.println(catpchaErr);
                }
            }
        } while (true);
    }
}
