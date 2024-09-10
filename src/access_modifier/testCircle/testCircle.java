package access_modifier.testCircle;

class testCircle {
    private double radius =1.0;
    private String color = "red";

    public testCircle(double radius) {
        this.radius = radius;
    }

    public testCircle() {
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    public double getRadius(){
        return  radius;
    }

    public double getArea(){
        return this.getRadius()*this.getRadius() * Math.PI;
    }



}
