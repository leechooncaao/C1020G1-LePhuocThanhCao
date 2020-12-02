package abstractclass_interface.thuc_hanh.comparator;

import kethua.thuc_hanh.Circle;

import java.util.Arrays;

public class ComparatorTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(5);
        circles[1] = new Circle(2);
        circles[2] = new Circle(7);

        System.out.println("Before sorting : ");
        for(var circle : circles)
            System.out.println(circle);

        System.out.println("After sorting : ");
        Arrays.sort(circles,new RadiusCompare());
        for(var circle : circles)
            System.out.println(circle);

    }
}
