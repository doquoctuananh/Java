package module2.ss7.resizeable;

public class Rectangle implements Resizeable {
    private double wide;
    private double longer;

    public Rectangle() {
    }

    public Rectangle(int wide, int longer) {
        this.wide = wide;
        this.longer = longer;
    }

    public double getWide() {
        return wide;
    }

    public void setWide(double wide) {
        this.wide = wide;
    }

    public double getLonger() {
        return longer;
    }

    public void setLonger(double longer) {
        this.longer = longer;
    }

    public double area(){
        return this.getWide()* this.getLonger();
    }

    @Override
    public void resize(double persent) {
        double sizeOld = this.area();

        this.setWide(this.getLonger() + persent);
        this.setLonger(this.getLonger() +persent);

        double areaResize = this.area();

        System.out.println("dien tich truoc khi tang la " + sizeOld
                + " sau khi tang " + areaResize);
    }

    public void information() {
        System.out.println("dien tich " + this.area());
    }
}
