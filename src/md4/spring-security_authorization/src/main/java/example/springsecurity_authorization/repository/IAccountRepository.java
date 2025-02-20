package example.springsecurity_authorization.repository;

import example.springsecurity_authorization.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
    Account findAccountByUsername(String username);
}
