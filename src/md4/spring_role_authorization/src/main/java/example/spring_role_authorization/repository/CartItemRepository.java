package example.spring_role_authorization.repository;

import example.spring_role_authorization.model.Account;
import example.spring_role_authorization.model.CartItem;
import example.spring_role_authorization.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    @Query("select case when count(*) >0 then true else false end from CartItem c " +
            " where c.account.id=:accountId and c.product.id=:productId")
    boolean exitsByProductAndAccount(@Param("productId")int productId,@Param("accountId") long accountId);

    @Query("select c from CartItem c" +
            " where c.account.id=:accountId")
    List<CartItem> selectALlProductOfAccount( @Param("accountId") long accountId);

    @Query("select c from CartItem c " +
            "where c.account.id=:accountId and c.product.id=:productId")
    Product selectProductByProductIdAndAccount(@Param("productId") int productId,@Param("accountId") int accountId);
}
