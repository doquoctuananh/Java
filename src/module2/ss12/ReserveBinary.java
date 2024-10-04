package module2.ss12;

import java.util.Scanner;
import java.util.Stack;

public class ReserveBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Decimal ");
        int decimal = Integer.parseInt(sc.nextLine());
        Stack<Integer> stack = new Stack<>() ;

        while(1>0){
            int a = decimal /2;
            if(a>0){
                int x = decimal %2;
                stack.add(x);
                decimal=a;
            }
            else if(a==0){
                int x = decimal %2;
                stack.add(x);
                break;
            }
        }
        String binary="";
        System.out.println("decimal reserve binary ");
        while(stack.size() >0){
            binary += stack.pop();
        }
        System.out.println(binary);

    }
}
