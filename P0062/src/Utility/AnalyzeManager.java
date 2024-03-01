package Utility;
import View.View;

public class AnalyzeManager {
    View view = new View();
    
    public String getPath(String path) {
        int fromDisk = path.indexOf("\\");
        int toNameFile = path.lastIndexOf("\\");
        return path.substring(fromDisk + 1, toNameFile);
    }

    public String getFileName(String path) {
        int positionFrom = path.lastIndexOf("\\");
        int positionTo = path.lastIndexOf(".");
        return path.substring(positionFrom + 1, positionTo);
    }

    public String getExtension(String path) {
        int positionDot = path.lastIndexOf(".");
        return path.substring(positionDot + 1, path.length());
    }

    public String getDisk(String path) {
        return path.substring(0, 2);
    }

    public String getFolder(String path) {
        int getLastPath = path.lastIndexOf("\\");
        if (getLastPath != -1) {
            String folderPath = path.substring(0, getLastPath);
            String[] folders = folderPath.split("\\\\");
            return "[" + folders[folders.length - 1] + "]"; 
        }
        return null; 
    }

    public void showResult(String path) {
        view.displayMess("Disk: " + getDisk(path));
        view.displayMess("Extension: " + getExtension(path));
        view.displayMess("File name: " + getFileName(path));
        view.displayMess("Path: " + getDisk(path) + "\\" + getPath(path));
        view.displayMess("Folder: "+ getFolder(path));
    }

}
