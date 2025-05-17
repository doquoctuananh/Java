package example.spring_security_jwt_version2.service.Jwt;

import example.spring_security_jwt_version2.model.UserPrincipal;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

// create,extra, validate : Jwt
@Component
public class JwtUtil {
    private final String secret = "tuananh1204" ;

    public String generateToken(UserPrincipal userPrincipal) {

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .claim("role", userPrincipal.getRole())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token, UserPrincipal userPrincipal) {
        try{
            String username = extractUsername(token);
            if(username.equals(userPrincipal.getUsername())) {
                return true;
            }
        }
        catch (JwtException e){
            System.out.println(e.getMessage());

        }
        return false;
    }
}
