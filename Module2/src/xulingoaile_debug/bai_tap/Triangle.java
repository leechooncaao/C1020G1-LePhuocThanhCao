package xulingoaile_debug.bai_tap;

public class Triangle {
    private int side1;
    private int side2;
    private int side3;

    public Triangle(int side1, int side2, int side3) throws IllegalTriangleException {
        if(validate(side1,side2,side3));
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}';
    }

    private boolean validate(int side1, int side2, int side3) throws IllegalTriangleException {
        if(side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1)
            return true;
        else throw new IllegalTriangleException();
    }
}
