package example.exam_module4.repository;

import example.exam_module4.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepositoty extends JpaRepository<Account, Integer> {
    Account findAccountByuserName(String username);
}
