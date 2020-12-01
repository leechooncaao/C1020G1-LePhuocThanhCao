package kethua.bai_tap.point2_3D;

public class Point2DTest {
    public static void main(String[] args) {
        var point2d = new Point2D();
        System.out.println(point2d);

        point2d = new Point2D(3,5);
        System.out.println(point2d);

        point2d.setXY(4,6);
        System.out.println(point2d);
    }
}
