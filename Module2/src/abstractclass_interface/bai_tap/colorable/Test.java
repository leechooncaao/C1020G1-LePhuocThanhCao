package abstractclass_interface.bai_tap.colorable;

import kethua.thuc_hanh.Circle;
import kethua.thuc_hanh.Rectangle;
import kethua.thuc_hanh.Shape;
import kethua.thuc_hanh.Square;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(2);
        shapes[1] = new SquareColorable(2);
        shapes[2] = new Rectangle(2, 3);

        for (var shape : shapes) {
            shape.printArea();

            if (shape instanceof SquareColorable) {
                SquareColorable square = (SquareColorable) shape;
                square.howToColor(new SquareColorable());
            }

        }
    }
}
