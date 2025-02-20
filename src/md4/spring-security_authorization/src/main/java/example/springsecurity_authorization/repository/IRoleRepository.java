package example.springsecurity_authorization.repository;

import example.springsecurity_authorization.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends   JpaRepository<Role, Long> {
    Role findRoleByRoleName(String name);
}
