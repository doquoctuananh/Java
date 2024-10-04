package module2.ss12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.lang.String;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("enter string: ");
        Scanner sc = new Scanner(System.in);
        String palindrome  = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < palindrome.length(); i++) {
            Character a=  palindrome.charAt(i);
            stack.push(a);
        }

        for (int i = 0; i < palindrome.length(); i++) {
            Character a=  palindrome.charAt(i);
            queue.add(a);
        }
        int count=0;
        for (int i = 0; i < palindrome.length(); i++) {
            if(stack.pop().equals(queue.poll())){
                count++;
            }
            else{
                break;
            }
        }

        if(count == palindrome.length()){
            System.out.println(palindrome + " is palindrome");
        }
        else{
            System.out.println(palindrome + " is not palindrome");
        }
    }
}
