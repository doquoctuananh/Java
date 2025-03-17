package example.spring_role_authorization.repository;

import example.spring_role_authorization.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
