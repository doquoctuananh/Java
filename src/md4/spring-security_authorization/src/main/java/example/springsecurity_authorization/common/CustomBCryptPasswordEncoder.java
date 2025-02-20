package example.springsecurity_authorization.common;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CustomBCryptPasswordEncoder {

    public static String customeBcryptPasswordEncoder(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static boolean parsePassword(String password, String currentPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(currentPassword, password);
    }
}
