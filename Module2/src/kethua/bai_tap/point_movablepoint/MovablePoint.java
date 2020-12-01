package kethua.bai_tap.point_movablepoint;

public class MovablePoint extends Point {
    private float xSpeed = 0f;
    private float ySpeed = 0f;

    public MovablePoint() {
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed){
        setxSpeed(xSpeed);
        setySpeed(ySpeed);
    }

    public float[] getSpeed(){
        float[] speed = new float[2];
        speed[0] = getxSpeed();
        speed[1] = getySpeed();

        return speed;
    }

    public MovablePoint move(){
        super.setX(super.getX() + xSpeed);
        super.setY(super.getY() + ySpeed);

        return this;
    }

    @Override
    public String toString() {
        return "(" + super.getX() + ";" + super.getY() + "), speed= (" + getxSpeed() + ";" + getySpeed() + ")";
    }
}
