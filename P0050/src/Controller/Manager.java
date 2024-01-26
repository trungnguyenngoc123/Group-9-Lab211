package Controller;

import Model.Model;
import View.Validation;
import java.util.ArrayList;

public class Manager {
    Validation validation = new Validation();
    public ArrayList<Float> calculateEquation (float a, float b){
        System.out.println();
        System.out.println("----- Calculate Equation -----");
        a = validation.checkInputFloat("Enter A: ");
        b = validation.checkInputFloat("Enter B: ");
        Model model = new Model(a, b,0);
        ArrayList<Float> number = new ArrayList<>();
        if(model.getA()==0 && model.getB()!=0){
            return null;
        }
        if(model.getA()==0 && model.getB()==0){
            return number;
        }
        if(model.getA()!=0){
            number.add(model.getA());
            number.add(model.getB());     
            number.add(- model.getB() / model.getA());       
        }
        return number;
    }

    public ArrayList<Float> calculateQuadraticEquation(float a, float b, float c){
        System.out.println("----- Calculate Quadratic Equation -----");
        a = validation.checkInputFloat("Enter A: ");
        b = validation.checkInputFloat("Enter B: ");
        c = validation.checkInputFloat("Enter C: ");
        Model model = new Model(a, b, c);
        ArrayList<Float> number = new ArrayList<>();
        float delta = model.getB() * model.getB() - 4 * model.getA() * model.getC();
        if(model.getA()==0 && model.getB() == 0 && model.getC() == 0){
            return number;
        }
        if(delta < 0){
            return null;
        }
        else if(delta == 0){
            number.add(model.getA());
            number.add(model.getB());
            number.add(model.getC());
            number.add(- model.getB() / (2 * model.getA()));
            number.add(- model.getB() / (2 * model.getA()));
        }
        else{
            number.add(model.getA());
            number.add(model.getB());
            number.add(model.getC());
            number.add((float)(- model.getB() - Math.sqrt(delta))/(2*model.getA()));
            number.add((float)(- model.getB() + Math.sqrt(delta))/(2*model.getA()));
        }
        return number;
    }
}
