package example.spring_security_jwt_version2.model.DTO;

import example.spring_security_jwt_version2.model.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String username;
    private Role role;
}
