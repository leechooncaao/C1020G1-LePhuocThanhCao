package kethua.thuc_hanh;

public class Shape {
    private String color = "green";
    private boolean filled = true;

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public Shape() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public void printArea(){

    }

    @Override
    public String toString() {
        var firstPart = "a shape with color of " + color + " and ";
        return  filled ? firstPart + "filled" : firstPart + "not filled";
    }
}
