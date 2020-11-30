package lopVaDoiTuong.bai_tap;

public class Fan {
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public Fan() {
        speed = SLOW;
        on = false;
        radius = 5;
        color = "Blue";
    }

    @Override
    public String toString() {
        var info = "; Color : " + color + "; Radius : " + radius;
        if(on)
            return "Fan is on; " + "Speed : " + speed + info;
        else
            return "Fan is off; " + "Speed : " + speed + info;
    }

    public int getSLOW() {
        return SLOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getFAST() {
        return FAST;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static void main(String[] args) {
        var fan1 = new Fan();
        var fan2 = new Fan();

        fan1.setColor("yellow");
        fan1.setSpeed(3);
        fan1.setRadius(10);
        fan1.setOn(true);

        fan2.setColor("blue");
        fan2.setSpeed(2);
        fan2.setRadius(5);

        System.out.println("Info of fan 1  : " + fan1);
        System.out.println("Info of fan 2  : " + fan2);
    }

}
