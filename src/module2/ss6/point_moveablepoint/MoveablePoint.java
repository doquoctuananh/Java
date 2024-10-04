package module2.ss6.point_moveablepoint;

public class MoveablePoint extends Point {
    private float xSpeed =0;
    private float ySpeed =0;

    public MoveablePoint(float x, float y,float xSpeed, float ySpeed) {
        super(x,y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }



    public MoveablePoint(float xSpeed, float ySpeed) {
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

    public void setSpeed(float xSpeed,float ySpeed) {
        this.ySpeed= ySpeed;
        this.xSpeed = xSpeed;
    }

    public float[] getSpeed() {
        float[] a = {this.xSpeed,this.ySpeed};
        return a;
    }

    @Override
    public String toString() {
        return super.toString() + "speed : " + this.xSpeed + " " + this.ySpeed;
    }

    public MoveablePoint move(){
        float x = super.getX() + this.xSpeed;
        float y = super.getY() + this.ySpeed;
        this.setX(x);
        this.setY(y);
        return this;
    }
}
