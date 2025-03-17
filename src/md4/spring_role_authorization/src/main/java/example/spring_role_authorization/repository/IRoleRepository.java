package example.spring_role_authorization.repository;

import example.spring_role_authorization.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Roles,Long> {
    Roles findByName(String name);
}
