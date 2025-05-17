package example.spring_security_jwt_version2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;


}
