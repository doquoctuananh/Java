package ss7.resizeable;

public class Square implements Resizeable {
    private int wide;

    public Square(int wide) {
        this.wide = wide;
    }

    public Square() {
    }

    public int getWide() {
        return wide;
    }

    public void setWide(int wide) {
        this.wide = wide;
    }

    public double area(){
        return this.getWide()* this.getWide();
    }

    @Override
    public void resize(double persent) {
        double sizeOld = this.area();
        double radius = persent+this.getWide();
        this.setWide((int)radius);
        double areaResize = this.area();
        System.out.println("dien tich truoc khi tang la " + sizeOld
                + " sau khi tang " + areaResize);
    }
    public void information() {
        System.out.println("dien tich " + this.area());
    }
}
