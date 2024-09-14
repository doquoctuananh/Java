package ss6.circle_cylinder;

public class Cylinder extends Circle {
    private int high;

    public Cylinder(){
        super();
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    @Override
    public double area() {
        return 2* Math.PI * this.getRadius() *(this.getRadius() + this.high);
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "high=" + high +
                super.toString() +
                '}';
    }
}
