package Validate;

import java.util.StringTokenizer;

public class Validation {

    public boolean isPositiveNumber(double salary) {
        return salary > 0;
    }

    public boolean isInputNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String capitalizeWords(String input) {
        if (input.length() == 0) {
            return input;
        }
        StringTokenizer stk = new StringTokenizer(input, " ");
        StringBuilder result = new StringBuilder(capitalizeFirst(stk.nextToken().toLowerCase()));
        while (stk.hasMoreElements()) {
            result.append(" ").append(capitalizeFirst(stk.nextToken().toLowerCase()));
        }
        return result.toString();
    }

    private String capitalizeFirst(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
