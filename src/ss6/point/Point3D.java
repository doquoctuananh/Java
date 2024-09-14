package ss6.point;

public class Point3D extends Point2D{
    private float z =0;
    public Point3D(float x, float y, float z){
        super(x,y);
        this.z=z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x,y);
        this.z = z;
    }
    public float[] getXYZ() {
        float[] a = {super.getX(),this.getY(),this.z};
        return a;
    }

    @Override
    public String toString() {
        return super.toString() + " z :" +this.z;
    }
}
