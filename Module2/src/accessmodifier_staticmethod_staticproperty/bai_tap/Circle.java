package accessmodifier_staticmethod_staticproperty.bai_tap;

public class Circle {
    private double radius = 1;
    private String color = "red";

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }
}
