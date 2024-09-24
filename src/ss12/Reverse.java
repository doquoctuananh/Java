package ss12;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size array: ");
        int size = Integer.parseInt(sc.nextLine());
        int[] arr = new int[size];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            System.out.println("enter " + i +" in stack ");
            int a = Integer.parseInt(sc.nextLine());
            stack.push(a) ;
        }
        for (int i = 0; i < arr.length; i++) {

            arr[i] = stack.pop();
        }
        System.out.println("reverse stack : "+ Arrays.toString(arr));

    }
}
