package Common;

import View.TaskView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validation {
    Library input = new Library();
    TaskView view = new TaskView();
    public final String PLAN_VALID = "^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$";

    public String checkInputString(String mess) {
        while (true) {
            String result = input.inputStr(mess).trim();
            if (result.length() == 0) {
                view.displayMess("Not empty.");
            } else {
                return result;
            }
        }
    }

    public int checkInputInt(String mess) {
        while (true) {
            try {
                int result = Integer.parseInt(checkInputString(mess));
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public String checkInputPlan(String mess) {
        while (true) {
            String result = checkInputString(mess);
            if (result.matches(PLAN_VALID) && Double.parseDouble(result) >= 8.0
                    && Double.parseDouble(result) <= 17.5) {
                return result;
            } else {
                view.displayMess("Re-input.");
            }
        }
    }
    public String checkInputDate(String mess) throws ParseException {
        while (true) {
            try {
                String result = checkInputString(mess);
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date date = format.parse(result);
                if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
                } else {
                    view.displayMess("Re-input");
                }
            } catch (NumberFormatException | ParseException ex) {
                view.displayMess("Re-input");
            }
        }
    }
}
