
package Control;

import Model.Model;
import View.Validation;
import java.util.Scanner;


public class Calculate extends Model{
    public Calculate() {
        super();
    }
    public final Scanner sc = new Scanner (System.in);
    public Model inputBinaryNum(){
        System.out.print("Enter a binary number: ");
        String binary = Validation.checkInputBinary();//ok
        return new Model(binary, 0, null);
    }
    public Model inputDecimalNum(){
        System.out.print("Enter a decimal number: ");
        int decimal = Validation.checkInputDecimal();//ok(change in necessary(double type))
        return new Model(null, decimal, null);
    }
    public Model inputHexNum(){
        System.out.print("Enter a hexadecimal number: ");
        String hex = Validation.checkInputHex();//ok
        return new Model(null, 0, hex);
    }
    
    
    public void convertBinaryToDecimal(Model model){//ok
        String binary = model.getBinaryNum();
        int decimal = 0;
        int p =0;
        int binary2 = Integer.parseInt(binary);
        while(true){
            if(binary2 == 0){
                break;
            }else{
                int temp = binary2 % 10;
                decimal += temp*Math.pow(2, p);
                binary2 = binary2 / 10;
                p++;
            }
        }
        model.setDecimalNum(decimal);
        System.out.println("Decimal number: "+model.getDecimalNum());
    }
    public void convertBinaryToHex(Model model) {//ok
    String binary = model.getBinaryNum();
    int decimal = Integer.parseInt(binary, 2);
    String hex = Integer.toHexString(decimal).toUpperCase();
    model.setHexNum(hex);
    System.out.println("Hexadecimal number: " + model.getHexNum());
    }
    //from binary done
    //caution decimal type is int not double
    
    public void convertDecimalToBinary(Model model){//ok
        int decimal = model.getDecimalNum();
        String binary =Integer.toBinaryString(decimal);
        model.setBinaryNum(binary);
        System.out.println("Binary number: "+model.getBinaryNum());
    }
    public final char[] hexDigits = {
        '0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };
    public void convertDecimalToHex(Model model){//ok
        int decimal = model.getDecimalNum();
        String hex = "";
        while(decimal !=0){
            hex = hexDigits[decimal % 16] + hex;
            decimal /= 16;
        }
        model.setHexNum(hex);
        System.out.println("Hexadecimal number: "+model.getHexNum());
    }
     
    //from decimal done 
    
    public void convertHexToDecimal (Model model){//ok
        String hex = model.getHexNum();
        int decimal = Integer.parseInt(hex, 16);
        model.setDecimalNum(decimal);
        System.out.println("Decimal number: "+model.getDecimalNum());
    }
    public void convertHexToBinary(Model model){//ok
        String hex = model.getHexNum();
        String binary = Integer.toBinaryString(model.getDecimalNum());
        model.setBinaryNum(binary);
        System.out.println("Binary number: "+model.getBinaryNum());
    }
    //from hex done
    }

