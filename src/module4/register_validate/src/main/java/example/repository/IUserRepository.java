package example.repository;

import example.model.User;
import example.model.UserLogin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User, Long> {
    @Query(value = "select new example.model.UserLogin(u.email,u.password) from User as u " +
            "where u.email = ?1 and u.password =?2")
    public UserLogin findByEmailAndPassword(String email, String password);
}
