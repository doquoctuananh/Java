package example.repository.customer;

import example.model.Customer;
import example.model.CustomerDTOView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    @Query("SELECT new example.model.CustomerDTOView(c.firstName, c.lastName, p.name) " +
            "FROM Customer AS c " +
            "JOIN Province AS p ON c.province.id = p.id " +
            "WHERE c.id = ?1")
    CustomerDTOView viewCustomer(long id);

}
