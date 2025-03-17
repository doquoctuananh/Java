package example.spring_role_authorization.repository;

import example.spring_role_authorization.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order,Long> {
    Page<Order> findAll(Pageable pageable);

    @Query("select o from Order o " +
            "where o.account.id=:customerId")
    List<Order> findByCustomerId(@Param("customerId") Long customerId);
}
