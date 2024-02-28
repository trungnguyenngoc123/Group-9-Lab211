
package Model;

import Common.Calculate;
import View.View;

public class Triangle extends Shape{
    private double a;
    private double b;
    private double c;
    View view = new View();
    Calculate ct = new Calculate();
    public Triangle() {
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public void printResult() {
        view.displayMess("Side A: " + a);
        view.displayMess("Side B: " + b);
        view.displayMess("Side C: " + c);
        view.displayMess("Area: " + getArea());
        view.displayMess("Perimeter: " + getPerimeter());
    }

    @Override
    public double getArea() {
        return ct.getAreaTri(a, b, c);
    }

    @Override
    public double getPerimeter() {
        return ct.getPerimeterTri(a, b, c);
    }
}
