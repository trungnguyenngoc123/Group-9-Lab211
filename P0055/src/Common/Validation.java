
package Common;

import Model.Doctor;
import View.Inputter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Validation {
    Inputter input = new Inputter();
    public String checkCode(){
        String code;
        do{
            code = input.inputStr("Enter code: ");
            if(code.isEmpty()){
                System.out.println("Empty input");
            }
        }while(code.isEmpty());
        String regex = ("[Dd][Oo][Cc]\\s{1}\\d+");
        if(!code.matches(regex)){
            System.out.println("Invalid Code, please input valid code");
            System.out.println("Example: DOC 1 or doc 1.");
            return checkCode();
        }
        return code.toUpperCase();
    }
    public String ifExistedCode(HashMap<String, Doctor> doctorMap, String Code) throws Exception {
        if(doctorMap.containsKey(Code)) throw new Exception("Doctor code ["+Code+"] is duplicate");
        return Code;
    }
    public String getStr(String msg){
        String str = getNonBlankStr(msg);
        String regex =("^" + "\\s*" + "([A-Za-z]+\\s?)*" + "\\s*" + "$");    
        if(!str.matches(regex)){
            System.out.println("Please input only text!");
            return getStr(msg);
        }
        if(str.isEmpty()){
            getStr(msg);
        }
        return str;
    }
    public String getNonBlankStr(String msg){
        String result = capitalWord(input.inputStr(msg).trim());
        if(result.isBlank()){
            System.out.print("Empty input!\n");
            return getNonBlankStr(msg);
        }
        return result;
    }
    public String capitalWord(String str){
        StringTokenizer stk = new StringTokenizer(str, " ");
        String result = capitalFirstChar(stk.nextToken().toLowerCase());
        while(stk.hasMoreElements()){
            result += " " + capitalFirstChar(stk.nextToken().toLowerCase());
        }
        return result;
    }
    public String capitalFirstChar(String str){
        if(str.isEmpty()||str==null)
            return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
