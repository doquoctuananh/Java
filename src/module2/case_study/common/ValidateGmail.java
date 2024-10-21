package module2.case_study.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateGmail {
    private static final String regex = "^[a-zA-Z0-9]+@gmail\\.com$";
    public static boolean checkEmail(String email){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
