package example.module4_examfinal.repository;

import example.module4_examfinal.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAll( Pageable pageable);

    @Query("SELECT p FROM Product p WHERE " +
            "(:name IS NULL OR p.nameProduct LIKE %:name%) " +
            "AND (:price IS NULL OR p.price >= :price) " +
            "AND (:typeId IS NULL OR p.typeProduct.id = :typeId)")
    List<Product> searchProducts(@Param("name") String name,
                                 @Param("price") Double price,
                                 @Param("typeId") Long typeId);
}
