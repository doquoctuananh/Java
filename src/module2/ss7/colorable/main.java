package module2.ss7.colorable;

import module2.ss7.resizeable.Circle;
import module2.ss7.resizeable.Rectangle;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("chon thong hinh ma ban muon nhap \n" +
                    "1. Rectangle \n" +
                    "2. Circle \n" +
                    "3. Square \n" +
                    "4. Thoat"
                    );
            int a = Integer.parseInt(sc.nextLine());
            switch (a){
                case 1:
                    System.out.println("nhap thong tin chieu wide");
                    int wide = Integer.parseInt(sc.nextLine());
                    System.out.println("nhap thong tin chieu long");
                    int longer =Integer.parseInt(sc.nextLine());
                    Rectangle r1 = new Rectangle();

                    System.out.println("thong tin Rectangle vua nhap ");
                    r1.information();
                    break;
                case 2:
                    System.out.println("nhap thong tin chieu wide");
                    int radius = Integer.parseInt(sc.nextLine());

                    Circle c1 = new Circle(radius);
                    System.out.println("thong tin Circle vua nhap ");
                    c1.Information();
                    break;
                case 3:
                    System.out.println("nhap thong tin chieu wide");
                    int wider = Integer.parseInt(sc.nextLine());

                    System.out.println("nhap thong tin chieu mau sac ");
                    String color = sc.nextLine();
                    SquareChild s1 = new SquareChild(wider,color);
                    System.out.println("thong tin Square vua nhap ");
                    s1.Information();
                    break;

                default: System.exit(0);
            }

        }
    }
}
