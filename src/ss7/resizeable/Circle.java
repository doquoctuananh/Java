package ss7.resizeable;

public class Circle implements Resizeable {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double area(){
        return this.getRadius()* this.getRadius()* Math.PI;
    }

    @Override
    public void resize(double persent) {
        double sizeOld = this.area();
        double radius = persent+this.getRadius();
        this.setRadius((int)radius);
        double areaResize = this.area();
        System.out.println("dien tich truoc khi tang la " + sizeOld
                + " sau khi tang " + areaResize);
    }

    public void Information(){
        System.out.println("dien tich " + this.area()
        );
    }
}
