package Common;

import Model.ValidateModel;
import View.View;

public class Inputter {

    Validation vd = new Validation();
    View view = new View();

    public ValidateModel inputData() {
        String phone, date, email;
        do {
            phone = vd.inputStr("Enter phone: ");
            phone = vd.checkPhone(phone);
        } while (!phone.matches("\\d{10}"));

        view.displayMess("====================");
        do {
            date = vd.inputStr("Enter Date: ");
            date = vd.checkDate(date);
        } while (!date.matches("^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[0-2])/\\d{4}$"));

        view.displayMess("====================");
        do {
            email = vd.inputStr("Enter Email: ");
            email = vd.checkEmail(email);
        } while (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"));
        return new ValidateModel(phone, date, email);
    }
}
