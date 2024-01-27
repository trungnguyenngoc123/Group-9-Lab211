/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DevelopCountry;
import View.Menu;
import java.util.ArrayList;

/**
 *
 * @author CO THAO
 */
public class Controller extends Menu {

    private ManageEastAsiaCountries mg;
    private ArrayList<DevelopCountry>lc = new ArrayList<>();
    public Controller() {
        super("\nMenu", new String[]{"Input the information of 11 countries in East Asia", "Display the information of country you've just input",
            "Search the information of country by user-entered name",
             "Display the information of countries sorted name in ascending order  ", "Exit"});
        mg = new ManageEastAsiaCountries(lc);
    }

    @Override
    public void execute(int ch) {
    switch(ch){
        case 1:
            mg.generation();
            mg.inputCountry(lc);
            break;
        case 2:
            mg.viewCountry();
            break;
        case 3:
            mg.search();
            break;
        case 4:
            mg.viewSortCountry();
            break;
        case 5:
            System.exit(0);
            break;
    }
    }

}
