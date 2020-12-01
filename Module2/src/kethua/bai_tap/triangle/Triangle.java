package kethua.bai_tap.triangle;

public class Triangle extends Shape {
    private double side1 = 1;
    private double side2 = 1;
    private double side3 = 1;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        if (isValidTriangle(side1, side2, side3)) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        } else throw new IllegalArgumentException("The inputs cannot be sides of triangle !");


    }

    public Triangle(String color, double side1, double side2, double side3) {
        super(color);

        if (isValidTriangle(side1, side2, side3)) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        } else throw new IllegalArgumentException("The inputs cannot be sides of triangle !");

    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getPerimeter() {
        return getSide1() + getSide2() + getSide3();
    }

    public double getArea() throws IllegalAccessException {
        double area;
        if (isValidTriangle(getSide1(), getSide2(), getSide3())) {
            var halfPerimeter = getPerimeter() / 2;
            area = Math.sqrt(halfPerimeter * (halfPerimeter - getSide1())
                    * (halfPerimeter - getSide2())
                    * (halfPerimeter - getSide3()));
        } else throw new IllegalAccessException("The inputs cannot be sides of triangle !");

        return area;
    }

    private boolean isValidTriangle(double side1, double side2, double side3) {
        return !(side1 + side2 <= side3) && !(side1 + side3 <= side2) && !(side2 + side3 <= side1);
    }

    @Override
    public String toString() {
        String result = "";
        try {
            result = "The triangle has 3 sides sequentially " + getSide1() + ", "
                    + getSide2() + ", " + getSide3() + " with area= "
                    + getArea() + ", perimeter= " + getPerimeter()
                    + " and color= " + super.getColor();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return result;
    }
}
