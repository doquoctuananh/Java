package module2.exception;

import java.util.Scanner;

public class IllegalTriangleException {

    public static void main(String[] args) throws Exception
    {
        System.out.println("nhap 3 canh tam giac a,b,c :  ");
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap a: ");
        int a= sc.nextInt();
        System.out.println("nhap b: ");
        int b= sc.nextInt();
        System.out.println("nhap c: ");
        int c= sc.nextInt();
        try{
            IllegalTriangleException ill = new IllegalTriangleException(a,b,c);
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    private int a;
    private int b;
    private int c;

    public IllegalTriangleException (int a , int b, int c) throws  Exception{
        if(a<0 || b<0 ||c <0){
            System.out.println("gia tri nhap vao khong dung co gia tri am");
            throw new Exception();
        }
        if((a+b)<c ||(a+c)<b || (c+b)<a){
            System.out.println("gia tri nay khong phai 3 canh tam giac vi tong 2 canh nho hon canh con lai");
            throw new Exception();
        }
    }

    public IllegalTriangleException() {
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

}
