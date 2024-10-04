package module2.ss7.resizeable;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;

        System.out.println("nhap gia tri kinh thuoc ban dau");
        int size = Integer.parseInt(sc.nextLine());
        Square c = new Square(size);


        double percent = Math.floor(Math.random() * 100) ;
        System.out.println("nhap gia tri tang la ngau nhien tu 1- 100 la " + percent);
        c.resize(percent);
    }
}
