package kethua.thuc_hanh;

public class Circle extends Shape{
    private double radius;

    public Circle() {
        radius = 1;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color,filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI*Math.pow(radius,2);
    }

    public double getPerimeter(){
        return 2*Math.PI*radius;
    }

    @Override
    public void printArea() {
        System.out.println("A Circle with area= " + getArea());
    }

    @Override
    public String toString() {
        return "A Circle with radius= " + radius + " and area= " + getArea() + " which is a subclass of " + super.toString() ;
    }
}
