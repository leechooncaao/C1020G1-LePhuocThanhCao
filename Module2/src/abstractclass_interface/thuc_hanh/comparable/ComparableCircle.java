package abstractclass_interface.thuc_hanh.comparable;
import kethua.thuc_hanh.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle>{

    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compareTo(ComparableCircle otherCircle) {
        if(this.getRadius() > otherCircle.getRadius()) return 1;
        else if(this.getRadius() < otherCircle.getRadius()) return -1;
        else return 0;

    }
}
