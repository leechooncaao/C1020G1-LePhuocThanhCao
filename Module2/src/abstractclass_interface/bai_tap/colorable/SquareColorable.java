package abstractclass_interface.bai_tap.colorable;

import kethua.thuc_hanh.Square;

public class SquareColorable extends Square implements Colorable {
    public SquareColorable() {
    }

    public SquareColorable(double side) {
        super(side);
    }

    public SquareColorable(String color, boolean filled, double side) {
        super(color, filled, side);
    }

    @Override
    public void printArea() {
        System.out.println("A square with area= " + getArea());
    }

    @Override
    public void howToColor(Object obj) {
        System.out.println(" Color all four sides");
    }
}
