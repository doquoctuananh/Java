package access_modifier.test_circle;

class TestCircle {
    private double radius =1.0;
    private String color = "red";

    public TestCircle(double radius) {
        this.radius = radius;
    }

    public TestCircle() {
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
