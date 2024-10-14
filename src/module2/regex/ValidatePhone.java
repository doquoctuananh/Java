package module2.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhone {
    private static  String regex = "^\\([0-9]{2}\\)-\\(0[0-9]{9}\\)$" ;
    public static boolean isValidate(String str){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String phone = null;
        do{
            phone = sc.nextLine();
        }while(!isValidate(phone));
        
        System.out.println(phone);
    }
}
