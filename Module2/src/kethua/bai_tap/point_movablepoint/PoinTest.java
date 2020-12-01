package kethua.bai_tap.point_movablepoint;

import java.util.Arrays;

public class PoinTest {
    public static void main(String[] args) {
        var point = new Point();
        System.out.println(point);

        point = new Point(1,2);
        System.out.println(point);

        point.setXY(3,4);
        System.out.println(Arrays.toString(point.getXY()));
    }
}
