package example.spring_security_jwt_version2.repository;

import example.spring_security_jwt_version2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Integer> {
    Role findByName(String name);
}
