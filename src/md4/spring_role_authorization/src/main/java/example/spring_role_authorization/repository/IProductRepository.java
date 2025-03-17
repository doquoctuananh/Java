package example.spring_role_authorization.repository;

import example.spring_role_authorization.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);

    @Query("select p from Product p where" +
            "(:name is null or p.name like concat('%',:name,'%') )" +
            "and (:color is null or p.color like concat('%',:color,'%') )" +
            "and (:price is null or p.price >= :price)")
    Page<Product> searchProductByNameAndColorAndPrice(@Param("name") String name,@Param("color") String color,
                                                      @Param("price")double price , Pageable pageable);
}
