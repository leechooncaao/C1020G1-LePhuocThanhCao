package abstractclass_interface.thuc_hanh.comparable;

import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(5);
        circles[1] = new ComparableCircle(2);
        circles[2] = new ComparableCircle(5);

        System.out.println("Before sorting : ");
        for(var circle : circles)
            System.out.print(circle.getRadius() + " ");

        System.out.println();

        System.out.println("After sorting : ");
        Arrays.sort(circles);
        for(var circle : circles)
            System.out.print(circle.getRadius() + " ");

    }
}
