package example.springsecurity.common;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPassword {

    public static String encryptPassWord(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static boolean parsePassword(String password, String currentPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(currentPassword,password);
    }
}
