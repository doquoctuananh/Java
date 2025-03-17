package example.spring_role_authorization.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CustomBcryptPasswordUtils {
    public static String customBcryptPasswordEncoder(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static boolean parsePassword(String passwordData,String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password,passwordData);
    }
}
