
package Controller;

import Utility.AnalyzeManager;
import Common.Validation;
import Model.File;
import View.Menu;


public class FilePathControl extends Menu {
    
    private AnalyzeManager mg;
    private Validation vd = new Validation();
    //private String input="";
    File file = new File();
    public FilePathControl() {
        super("Analysis Path Program", new String[]{"Input Path","Show result","Exit"});
        mg = new AnalyzeManager() ;
    }
    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                String inputPath = vd.checkInputString("Enter input Path: ");
                file.setInputPath(inputPath);
                break;
            case 2:
                mg.showResult(file.getInputPath());
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
}

