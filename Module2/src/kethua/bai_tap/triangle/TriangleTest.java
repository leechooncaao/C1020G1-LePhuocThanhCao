package kethua.bai_tap.triangle;

public class TriangleTest {
    public static void main(String[] args) {
        var triangle = new Triangle();
        System.out.println(triangle);

        // situation in which the triangle is invalid
        triangle.setSide1(1);
        triangle.setSide2(2);
        triangle.setSide3(3);
        System.out.println(triangle);


    }
}
