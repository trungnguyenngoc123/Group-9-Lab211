package Controller;

import Model.TextModel;
import View.TextView;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextController {

    private TextModel model;
    private TextView view;

    public TextController(TextModel model, TextView view) {
        this.model = model;
        this.view = view;
    }

    public void processText() {
        try {
            normalizeText();
            view.displayMessage("Text normalization completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            view.displayMessage("Error: " + e.getMessage());
        }
    }

    private void normalizeText() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(model.getInputFileName())); BufferedWriter writer = new BufferedWriter(new FileWriter(model.getOutputFileName()))) {

            boolean isFirstLine = true;
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    line = removeBlankLineBetweenLines(line);
                    line = removeSpacesInsideQuotes(line);
                    line = normalizeOneSpaceBetweenWords(line);
                    line = dotLastLine(line);
                    line = normalizeOneSpaceAfterPunctuation(line);
                    line = capitalizeAfterDot(line);
                    line = capitalizeFirstWordInFirstLine(line, isFirstLine);
                    line = removeSpaceBeforeCommaAndDot(line);
                    writer.write(line);
                    isFirstLine = false;
                }
            }
        } catch (IOException e) {
            throw new IOException("Error reading or writing file: " + e.getMessage());
        }
    }

    private String capitalizeAfterDot(String line) {
        StringBuilder sb = new StringBuilder(line);

        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == '.' && Character.isWhitespace(sb.charAt(i + 1))) {
                if (i + 2 < sb.length()) {
                    sb.setCharAt(i + 2, Character.toUpperCase(sb.charAt(i + 2)));
                    i++; 
                }
            }
        }

        return sb.toString();
    }

    private String dotLastLine(String str) {
        return str.endsWith(".") ? str : str + ".";
    }

    private String normalizeOneSpaceAfterPunctuation(String line) {
        return line.replaceAll("\\s(?=[.,:])", "");
    }

    private String normalizeOneSpaceBetweenWords(String line) {
        return line.replaceAll("\\s+", " ");
    }

    private String removeSpacesInsideQuotes(String line) {
        String pattern = "\"\\s+(.*?)\\s+\"";
        line = line.replaceAll(pattern, "\"$1\"");
        return line;
    }

    private String removeBlankLineBetweenLines(String line) {
        return line.trim();
    }

    private String capitalizeFirstWordInFirstLine(String line, boolean isFirstLine) {
        return isFirstLine ? line.substring(0, 1).toUpperCase() + line.substring(1) : line;
    }

    private String removeSpaceBeforeCommaAndDot(String line) {
        return line.replaceAll("(?<!\\s)[.,](?!\\s)", "$0 ");
    }
}
