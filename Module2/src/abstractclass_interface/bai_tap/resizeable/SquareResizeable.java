package abstractclass_interface.bai_tap.resizeable;

import kethua.thuc_hanh.Square;

public class SquareResizeable extends Square implements Resizeable {
    public SquareResizeable() {
    }

    public SquareResizeable(double side) {
        super(side);
    }

    public SquareResizeable(String color, boolean filled, double side) {
        super(color, filled, side);
    }

    @Override
    public void resize(double rate) {
        this.setSide(this.getSide() + this.getSide()*rate/100);
    }
}
