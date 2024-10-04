package module2.oop.quadraticequation;

public class quadraticEquation {
    private double a ;
    private double b ;
    private double c ;
    private double dental ;
    public quadraticEquation(double a,double b, double c){
        this.a =a;
        this.b = b;
        this.c= c;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant(){
        dental = this.b*this.b - 4*this.a*this.c;

        return dental;
    }
    public void getRoot1(){
        if(this.getDiscriminant() < 0){
            System.out.println("Phuong trinh vo nghiem");

        }
        else{
            double dentalRoot = Math.sqrt(this.getDiscriminant());
            double r1 = (-b+dentalRoot)/(2*a);
            System.out.println("phuong trinh co nghiem " + r1);
        }
    }
    public void getRoot2(){
        if(this.getDiscriminant() < 0){
            System.out.println("Phuong trinh vo nghiem");

        }
        else{
            double dentalRoot = Math.sqrt(this.getDiscriminant());
            double r2 = (-b-dentalRoot)/(2*a);
            System.out.println("phuong trinh co nghiem " +r2);
        }
    }

}