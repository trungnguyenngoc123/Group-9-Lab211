package Validate;

import View.View;
import java.util.StringTokenizer;

public class Validation {
View view = new View();
    public boolean isPositiveNumber(double salary) {
        if(salary<=0){  
            view.displayMess("Salary must be greater than 0.");
            return false;
        }
        return salary > 0;
    }
public boolean isText(String input) {
    return input != null && !input.isEmpty() && input.matches("^[a-zA-ZÀ-ỹ\\s]+$");
}

public String capitalizeWords(String input) {
    if (input == null || input.isEmpty()) {
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
