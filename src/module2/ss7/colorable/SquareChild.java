package module2.ss7.colorable;

public class SquareChild extends module2.ss7.resizeable.Square implements Colorable {
    private String color = "blue";

    public SquareChild(int wide, String color) {
        super(wide);
        this.color = color;
    }

    public SquareChild() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void howTocolor() {
        System.out.println(" Color all four sides");
    }

    public void Information(){
        System.out.println("dien tich " + this.area()
            + " Color all four sides"
        );
    }
}
