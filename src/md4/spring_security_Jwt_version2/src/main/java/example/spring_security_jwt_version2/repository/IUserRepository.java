package example.spring_security_jwt_version2.repository;

import example.spring_security_jwt_version2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
