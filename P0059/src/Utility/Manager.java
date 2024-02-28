package Utility;

import Model.Person;
import Validate.Validation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Manager {
    private final Validation validate = new Validation();

    public void getPerson() {
        //avc
        System.out.println("--------------Person info---------------");
        String path = validate.filePath();
        double money = validate.getMoney();
        try {
            showResult(getPersons(path, money));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public ArrayList<Person> getPersons(String path, double money) throws IOException {
        File file = new File(path);
        if (!file.exists() || file.length() == 0) {
            throw new FileNotFoundException("File doesn't exist or is empty!");
        }
        if (!file.canRead()) {
            throw new IOException("Cannot read file!");
        }

        ArrayList<Person> list = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(file);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {

            String line = br.readLine();
           while (line != null) {              
            String[] arr = line.split(";");
            if(arr.length >= 3) {                    
                String name = arr[0];
                String address = arr[1];
                double salary;
                try {
                    salary = Double.parseDouble(arr[2]);
                } catch (NumberFormatException e) {
                    salary = 0;
                }

                if (salary >= money) {
                    list.add(new Person(name, address, salary));
                } else {      
                    System.err.println("Invalid line format: " + line);
                }
            }
            else {
                System.err.println("Invalid line format: " + line);
            }
            line = br.readLine();
        }
    }

    return list;
}

    public void copyText() {
    try {    
        String sourcePath = validate.filePath();            
        String destinationPath = "D:\\Java\\P0059\\"+ validate.fileDesti();
        
        try (FileInputStream fis = new FileInputStream(sourcePath);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter(destinationPath);
             BufferedWriter bw = new BufferedWriter(fw)) {

            String line = br.readLine();
            while (line != null) {
                bw.write(line);
                bw.newLine(); 
                line = br.readLine();
            }

            System.out.println("Copy done...");

        } catch (IOException e) {
            System.out.println("Error copying text to file: " + e.getMessage());
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}

    public void showResult(ArrayList<Person> list) {
        System.out.println("------------- Result ----------");
        Collections.sort(list);
        System.out.printf("%-15s %-15s %-7s\n", "Name", "Address", "Salary");
        for (Person x : list) {
            x.display();
        }
        if(!list.isEmpty()){
            System.out.println("\nMax: "+list.get(list.size()-1).getName());
            System.out.println("Min: "+list.get(0).getName());
        }
    }
}
