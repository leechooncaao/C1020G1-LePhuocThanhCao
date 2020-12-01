package kethua.bai_tap.point2_3D;

public class Point3D extends Point2D {
    private float z = 0f;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z){
        super.setX(x);
        super.setY(y);
        setZ(z);
    }

    public float[] getXYZ(){
        float[] coordinate = new float[3];
        coordinate[0] = super.getX();
        coordinate[1] = super.getY();
        coordinate[2] = getX();

        return coordinate;
    }

    @Override
    public String toString() {
        return "Point3D has coordinate= {"+super.getX() + ";" + super.getY() + ";" + getZ() + "}";
    }
}
