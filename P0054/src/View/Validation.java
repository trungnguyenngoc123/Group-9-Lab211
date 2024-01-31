package View;

import Model.Contact;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Validation {

    Scanner sc = new Scanner(System.in);

    public int inputID(String t) {
        System.out.print(t);
        while (true) {
            try {
                int id = Integer.parseInt(sc.nextLine());
                return id;
            } catch (Exception e) {
                System.out.println("ID is a digit!");
                System.out.print("Enter again: ");
            }
        }
    }

    public String getNonBlankStr(String msg) {
        String result;
        System.out.print(msg);
        result = normalizeAndRecapitalize(sc.nextLine());
        //throw new exception for empty input
        if (result.isEmpty()) {
            System.out.print("Empty input!\n");
            return getNonBlankStr(msg);
        }
        return result;
    }

    public String capitalizeFirstChar(String str) {
        //If the string is null or empty return immediately.
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public String normalizeAndRecapitalize(String S) {
        //Check if the input is empty
        if (S.length() == 0) {
            return S;
        }
        StringTokenizer stk = new StringTokenizer(S, " ");
        String result = capitalizeFirstChar(stk.nextToken().toLowerCase());
        //Capitalize the first char of each token and merge them back into input
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
            String result = sc.nextLine();
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
