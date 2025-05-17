package example.spring_security_jwt_version2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private Integer id;
    private String token;
    private String type = "Bearer";
    private String username;
    private Role role;

}
