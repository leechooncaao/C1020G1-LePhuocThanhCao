package kethua.bai_tap.point2_3D;

public class Point3DTest {
    public static void main(String[] args) {
        var point3d = new Point3D();
        System.out.println(point3d);

        point3d = new Point3D(5,6,7);
        System.out.println(point3d);

        point3d.setXYZ(2,3,4);
        System.out.println(point3d);
    }
}
