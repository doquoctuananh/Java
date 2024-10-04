package module2.ss6.point;

public class Point2D {
    private float x =0;
    private float y= 0;

    public Point2D(){

    }
    public Point2D(float x,float y){
        this.x =x;
        this.y = y;
    }

    public void setX(float x){
        this.x= x;
    }
    public float getX(){
        return this.x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y){
        this.x= x;
        this.y = y;
    }
    public float[] getXY(){
        float [] a = {this.x,this.y};
        return a;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
