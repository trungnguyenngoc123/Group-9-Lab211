
package Model;

import Common.Calculate;
import View.View;

public class Rectangle extends Shape {

    private double width;
    private double length;    
    Calculate ct = new Calculate();
    View view = new View();
    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    @Override
    public double getArea() {//test
        return ct.getAreaRec(width, length);
    }

    @Override
    public double getPerimeter() {
        return ct.getPerimeterRec(width, length);
    }

    @Override
    public void printResult() {
        view.displayMess("Width: " + width);
        view.displayMess("Length: " + length);
        view.displayMess("Area: " + getArea());
        view.displayMess("Perimeter: " + getPerimeter());
    }

}