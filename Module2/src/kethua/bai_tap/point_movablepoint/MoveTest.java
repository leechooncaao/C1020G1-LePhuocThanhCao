package kethua.bai_tap.point_movablepoint;

public class MoveTest {
    public static void main(String[] args) {
        var movePoint = new MovablePoint();
        System.out.println(movePoint);

        movePoint = new MovablePoint(3,5);
        System.out.println(movePoint);

        movePoint = new MovablePoint(1,2,3,4);
        System.out.println(movePoint);

        movePoint.setSpeed(5,5);
        System.out.println(movePoint);

        movePoint.move();
        System.out.println(movePoint);
    }
}
