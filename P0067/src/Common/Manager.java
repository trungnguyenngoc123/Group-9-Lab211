package Common;

import Model.Analysis;
import View.View;
import java.util.HashMap;
import java.util.List;

public class Manager {

    Validate vali = new Validate();
    private Analysis model;
    private View view = new View();

    public Manager() {
        this.model = new Analysis();
    }

    public void Analize() {
        String input = vali.getStringFromInput("Input String: ");
        view.displayMess("Result Analysis");

        HashMap<String, List<Integer>> numbersAnalysis = model.getNumber(input);
        HashMap<String, StringBuilder> charactersAnalysis = model.getCharacter(input);

        view.displayMess("Perfect Square Numbers: " + numbersAnalysis.get("Perfect Square Numbers"));
        view.displayMess("Odd Numbers: " + numbersAnalysis.get("Odd Numbers"));
        view.displayMess("Even Numbers: " + numbersAnalysis.get("Even Numbers"));
        view.displayMess("All Numbers: " + numbersAnalysis.get("All Numbers"));

        view.displayMess("Uppercase Characters: " + charactersAnalysis.get("Uppercase Characters"));
        view.displayMess("Lowercase Characters: " + charactersAnalysis.get("Lowercase Characters"));
        view.displayMess("Special Characters: " + charactersAnalysis.get("Special Characters"));
        view.displayMess("All Characters: " + charactersAnalysis.get("All Characters"));
    }

}
