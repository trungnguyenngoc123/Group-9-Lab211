package Library;

import Model.Contact;
import View.Inputter;
import java.util.List;
import java.util.StringTokenizer;

public class Validation {
    
    Inputter input = new Inputter();
    
    public String getNonBlankStr(String msg) {
        System.out.print(msg);
        String result = normalizeAndRecapitalize(input.inputStr());
        if (result.isEmpty()) {
            System.out.print("Empty input!\n");
            return getNonBlankStr(msg);
        }
        return result;
    }

    public String capitalizeFirstChar(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public String normalizeAndRecapitalize(String S) {
        if (S.length() == 0) {
            return S;
        }
        StringTokenizer stk = new StringTokenizer(S, " ");
        String result = capitalizeFirstChar(stk.nextToken().toLowerCase());
        while (stk.hasMoreElements()) {
            result += " " + capitalizeFirstChar(stk.nextToken().toLowerCase());
        }
        return result;
    }

    public String getStr(String msg) {
        String str = getNonBlankStr(msg);
        String regex = ("^" + "\\s*" + "([A-Za-z]+\\s?)*" + "\\s*" + "$");
        if (!str.matches(regex)) {
            System.out.println("Please input only text!");
            return getStr(msg);
        }
        return str;
    }

    public String inputPhone(String t) {
        System.out.print(t);
        String regex = "[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}"
                + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+";
        while (true) {
            String result = input.inputStr();
            if (result.matches(regex)) {
                return result.replaceAll("\\D+", "").substring(0, 10);
            }else{
            System.out.println("Please input a phone number has the following format:\n"
                    + "•	1234567890\n"
                    + "•	123-456-7890\n"
                    + "•	123-456-7890 x1234\n"
                    + "•	123-456-7890 ext1234\n"
                    + "•	(123)-456-7890\n"
                    + "•	123.456.7890\n"
                    + "•	123 456 7890");
            System.out.print("Enter again: ");
            }
        }
    }

    public Contact checkExistContact(List<Contact> List, int ID) {
        if (List.isEmpty()) {
            System.out.println("There are no contact do delete!");
            return null;
        }
        for (Contact x : List) {
            if (x.getID() == ID) {
                return x;
            }
        }
        System.out.println("No found contact!");
        return null;
    }
}
