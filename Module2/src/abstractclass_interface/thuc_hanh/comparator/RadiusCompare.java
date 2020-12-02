package abstractclass_interface.thuc_hanh.comparator;

import kethua.thuc_hanh.Circle;

import java.util.Comparator;

public class RadiusCompare implements Comparator<Circle> {
    @Override
    public int compare(Circle o1, Circle o2) {
        if(o1.getRadius() > o2.getRadius()) return 1;
        else if (o1.getRadius() < o2.getRadius()) return -1;
        else return 0;
    }
}
