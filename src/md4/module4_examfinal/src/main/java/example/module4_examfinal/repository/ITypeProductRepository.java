package example.module4_examfinal.repository;

import example.module4_examfinal.model.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeProductRepository extends JpaRepository<TypeProduct, Long> {
}
