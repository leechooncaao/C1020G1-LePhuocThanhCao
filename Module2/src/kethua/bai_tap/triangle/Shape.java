package kethua.bai_tap.triangle;

public class Shape {
    private String color = "blue";

    public Shape() {
    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "A shape has color= " + getColor();
    }
}
