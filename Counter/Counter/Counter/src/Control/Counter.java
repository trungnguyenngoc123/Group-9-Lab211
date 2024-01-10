package Control;

import Model.Model;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Counter extends Model{
    
    private Map<Character, Integer> charCounter = 
            new HashMap<Character, Integer>();
    
    private Map<String, Integer> wordCounter =
            new HashMap<String, Integer>();
    
    public void displayWordCounter() {
        System.out.println(wordCounter);
    }
    public void displayCharCounter(){
        System.out.println(charCounter);
    }
    
    public Model inputter(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your content: ");
        String content = sc.nextLine();
        return new Model(content);
    }
    
    public void analyze(Model content) {
    String contentString = content.getInputString(); // Assuming getContent is a method in the Model class
    if (contentString == null) {
        System.out.println("Content is null.");
        return;
    }

    for (char ch : contentString.toCharArray()) {
        if (Character.isSpaceChar(ch)) {
            continue;
        }
        if (!charCounter.containsKey(ch)) {
            charCounter.put(ch, 1);
        } else {
            charCounter.put(ch, charCounter.get(ch) + 1);
        }
    }

    StringTokenizer tokenizer = new StringTokenizer(contentString);
    while (tokenizer.hasMoreTokens()) {
        String token = tokenizer.nextToken();
        if (!wordCounter.containsKey(token)) {
            wordCounter.put(token, 1);
        } else {
            wordCounter.put(token, wordCounter.get(token) + 1);
        }
    }
}

}