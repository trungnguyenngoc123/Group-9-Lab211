package Controller;

import Model.TextModel;
import View.Menu;
import View.TextView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Controller extends Menu {

    private TextModel model = new TextModel();
    private TextView view = new TextView();

    public Controller() {
        super("\nNormalize System", new String[]{"Load File", "Normalize", "Exit"});
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                boolean validFileName = false;
                while (!validFileName) {
                    try {
                        String inputFileName = view.getInputFileName();
                        BufferedReader br = new BufferedReader(new FileReader(inputFileName));
                        String outputFileName = view.getOutputFileName();
                        while (true) {
                            if (!fileExists(outputFileName)) {
                                System.out.println("Output file does not exist. Please enter an existing output file name!");
                                outputFileName = view.getOutputFileName();
                            } else {
                                break;
                            }
                        }
                        model.setInputFileName(inputFileName);
                        model.setOutputFileName(outputFileName);
                        br.close();
                        validFileName = true;
                    } catch (FileNotFoundException ex) {
                        System.out.println("File not found");
                    } catch (IOException ex) {
                        System.out.println("Line is null");;
                    }
                }
                break;
            case 2:
                if(model.getInputFileName() != null && model.getOutputFileName() != null){
                    new TextModel(model.getInputFileName(), model.getOutputFileName());
                    TextController controller = new TextController(model, view);
                    controller.processText();
                }else{
                    System.out.println("You should input load file first!");
                    return;
                }
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

    private boolean fileExists(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }
}
