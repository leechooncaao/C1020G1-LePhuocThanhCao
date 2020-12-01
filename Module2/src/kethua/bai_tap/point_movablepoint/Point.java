package kethua.bai_tap.point_movablepoint;

public class Point {
    private float x = 0f;
    private float y = 0f;

    public Point() {
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y){
        setX(x);
        setY(y);
    }

    public float[] getXY(){
        float[] coordinate = new float[2];
        coordinate[0] = getX();
        coordinate[1] = getY();

        return coordinate;
    }

    @Override
    public String toString() {
        return "Point2D has coordinate {" + getX() + ";" + getY() + "}";
    }
}
