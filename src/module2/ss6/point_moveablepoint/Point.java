package module2.ss6.point_moveablepoint;

public class Point {
    private float x =0;
    private float y =0;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
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

    public void setXY(float x,float y) {
        this.x =x;
        this.y = y;
    }

    public float[] getXY() {
        float a [] = {this.x,this.y};
        return a;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
