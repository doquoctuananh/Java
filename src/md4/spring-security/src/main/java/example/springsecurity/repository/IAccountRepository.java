package example.springsecurity.repository;

import example.springsecurity.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
    Account findAccountByUsername(String username);
}
