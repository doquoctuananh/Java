package module2.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClass {
    public final static  String regex = "^[CAP][0-9]{4}[GHIK]$" ;
    public static boolean isValidate(String str){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String enterClass = null;
        do{
            enterClass = sc.nextLine();
        }while(!isValidate(enterClass));

        System.out.println(enterClass);
    }
}
