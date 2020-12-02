package abstractclass_interface.bai_tap.resizeable;

import kethua.thuc_hanh.Rectangle;

public class RectangleResizeable extends Rectangle implements Resizeable {
    public RectangleResizeable() {
    }

    public RectangleResizeable(String color, boolean filled, double width, double length) {
        super(color, filled, width, length);
    }

    public RectangleResizeable(double width, double length) {
        super(width, length);
    }

    @Override
    public void resize(double rate) {
        this.setWidth(this.getWidth() + this.getWidth()*rate/100);
        this.setLength(this.getLength() + this.getLength()*rate/100);
    }
}
