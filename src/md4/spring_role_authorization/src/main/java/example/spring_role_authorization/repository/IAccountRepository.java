package example.spring_role_authorization.repository;

import example.spring_role_authorization.model.Account;
import example.spring_role_authorization.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
    Optional<Account> findById(int id);
    Account findByEmail(String email);

}
