
package View;

import java.util.Scanner;

public class TextView {
    
    public String getInputFileName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter input file name: ");
        return sc.nextLine();
    }

    public String getOutputFileName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter output file name: ");
        return sc.nextLine();
    }
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
