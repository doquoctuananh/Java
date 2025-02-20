package example.exam_module4.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CustomBcryptPassword {
    public static String customeBcryptPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static boolean parsePassword(String password,String currentPassword){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(currentPassword,password);
    }
}
