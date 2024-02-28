package Common;

import Model.Circle;
import Model.Rectangle;
import Model.Triangle;
import View.View;

public class Calculate {

    View view = new View();
    Validation vd = new Validation();

    public Triangle inputTriangle() {
        while (true) {
            double a = vd.checkInputDouble("Please input side A of Triangle: ");
            double b = vd.checkInputDouble("Please input side B of Triangle: ");
            double c = vd.checkInputDouble("Please input side C of Triangle: ");
            if ( a + b > c && b + c > a && a + c > b) {
                return new Triangle(a, b, c);
            } else {
                view.displayMess("Invalid input, please input with a + b > c and b + c > a and a + c > b");
            }
        }
    }
    public double getAreaTri(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
    public double getPerimeterTri(double a, double b, double c) {
        return a + b + c;
    }

    public Rectangle inputRectangle() {
        while (true) {
            double width = vd.checkInputDouble("Please input side width of Rectangle: ");
            double length = vd.checkInputDouble("Please input length of Rectangle: ");
            return new Rectangle(width, length);
        }
    }
    public double getAreaRec(double width, double length) {
        return width * length;
    }
    public double getPerimeterRec(double width, double length) {
        return 2 * (width + length);
    }
    
    public Circle inputCircle(){
        while (true)  { //abcbcbc
            double radius = vd.checkInputDouble("Please input radius of Circle: ");
            return new Circle(radius);
        }
    }
    public double getAreaCir(double radius) {
        return Math.PI * radius * radius;
    }
    public double getPerimeterCir(double radius) {
        return Math.PI * 2 * radius;
    }
    public void displayCircle(Circle circle) {
        circle.printResult();
    }

    public void displayTrian(Triangle trigle) {
        trigle.printResult();
    }

    public void displayRectan(Rectangle rectangle) {
        rectangle.printResult();
    }
}
