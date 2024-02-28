
package Model;

import Common.Calculate;
import View.View;

public class Circle extends Shape {

    private double radius;
    Calculate ct = new Calculate();
    View view = new View();
    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return ct.getAreaCir(radius);
    }

    @Override
    public double getPerimeter() {
        return ct.getPerimeterCir(radius);
    }

    @Override
    public void printResult() {
        view.displayMess("Radius: " + this.radius);
        view.displayMess("Area: " + getArea());
        view.displayMess("Perimeter: " + getPerimeter());
    }    
}
