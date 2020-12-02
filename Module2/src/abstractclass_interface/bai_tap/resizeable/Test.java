package abstractclass_interface.bai_tap.resizeable;

import kethua.thuc_hanh.Shape;

public class Test {
    public static void main(String[] args) {
        Resizeable[] shapes = new Resizeable[3];
        shapes[0] = new CircleResizeable(4);
        shapes[1] = new RectangleResizeable(2,4);
        shapes[2] = new SquareResizeable(3);

        System.out.println("Before resizing : ");
        for(var shape : shapes)
            System.out.println(shape);

        System.out.println();

        System.out.println("After resizing with a random rate : ");
        double randomRate ;
        for(var shape : shapes){
            randomRate = Math.floor(Math.random()*99 + 1);
            shape.resize(randomRate);
            System.out.println(shape  + "; rate= " + randomRate);
        }
    }
}
