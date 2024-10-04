package module2.oop.fan;


class Fan {
    private final int slow =1;
    private final int medium =2;
    private final int fast =3;
    private int speed = this.slow;
    private boolean on;
    private  double radius = 5;
    private  String color ="blue";

    public Fan(int speed,double radius, String color){
        this.speed = speed;
        this.radius = radius;
        this.color = color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSlow() {
        return slow;
    }

    public int getMedium() {
        return medium;
    }

    public int getFast() {
        return fast;
    }

    public int getSpeed() {
        return speed;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }
    public String toString(){
        if(this.on){
            return
                    this.getSpeed() + " " +this.getColor() + " "+this.getRadius()+ " Fan is on";
        }
        else{
            return
                    this.getColor() +" "+ this.getRadius()+ " Fan is off";
        }
    }
}
