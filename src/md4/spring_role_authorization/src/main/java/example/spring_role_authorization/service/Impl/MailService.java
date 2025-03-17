package example.spring_role_authorization.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MailService {
    @Autowired
    private JavaMailSender mailSender;

    public String renderOTP(){
        Random random = new Random();
        int otp = random.nextInt(999999);
        return String.valueOf(otp);
    }

    public void sendOTP(String email,String subject,String text){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setSubject(subject);
        message.setText(text );
        mailSender.send(message);
    }
}
