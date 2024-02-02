package View;

import java.util.Scanner;

public class Inputter {
    Scanner sc = new Scanner(System.in);
    public int checkAvailability() throws Exception{
        int availability;
        try{
            System.out.print("Enter availability: ");
            availability = Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            throw new Exception("Invalid input, please input a integer number!"); 
        }
        if (availability <= 0 ) {
            throw new Exception("Availability must larger than 0");
        }
        return availability;
    }
    public String inputStr(String mess){
        System.out.print(mess);
        String result = sc.nextLine();
        return result;
    }
}
