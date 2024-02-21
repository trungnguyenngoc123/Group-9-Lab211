package Common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import Model.Words;
import View.Inputter;
import View.View;

public class Manage {

    final HashMap<String, Words> words = new HashMap<>();
    final View view = new View();
    final Inputter input = new Inputter();
    public void addWord() {
        view.display("------------- Add -------------");
        String eng = input.checkString("Enter English: ");
        eng = eng.substring(0, 1).toUpperCase() + eng.substring(1);
        String vie = input.checkString("Enter Vietnamese: ");
        vie = vie.substring(0, 1).toUpperCase() + vie.substring(1);
        Words w = new Words(eng, vie);
        words.put(eng, w);
    }

    public void deleteWord() {
        view.display("------------ Delete ----------------");
        String eng;
        boolean isExist;
        do {
            eng = input.checkString("Enter English: ");
            isExist = false;
            for (String key : words.keySet()) {
                if (key.equalsIgnoreCase(eng)) {
                    words.remove(key);
                    view.display("Word deleted successfully!");
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                System.out.println("Word not found!");
            }
        } while (!isExist);
    }

    public void translateWord() {
        view.display("------------- Translate ------------");
        String eng;
        boolean isExist;
        do {
            eng = input.checkString("Enter English: ");
            isExist = false;
            for (String key : words.keySet()) {
                if (key.equalsIgnoreCase(eng)) {
                    view.display("Vietnamese: " + words.get(key).getVietnamese());
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                view.display("Word not found! Try again.");
            }
        } while (!isExist);
    }

    public void readFile(String filename) {
        try {
            BufferedReader read = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = read.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String eng = parts[0].trim();
                    String vie = parts[1].trim();
                    Words w = new Words(eng, vie);
                    words.put(eng, w);
                }
            }
        } catch (IOException e) {
            view.display("File not found!");
        }
    }

    public void writeFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Map.Entry<String, Words> entry : words.entrySet()) {
                String eng = entry.getKey();
                String vie = entry.getValue().getVietnamese();
                writer.write(eng + ", " + vie);
                writer.newLine();
            }
            view.display("Successful");
        } catch (IOException e) {
            view.display("Error writing to file: " + e.getMessage());
        }
    }
}
