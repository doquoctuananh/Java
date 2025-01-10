package example.service;

import example.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<User> findAll(Pageable pageable);
    User findById(long id);
    void save(User user);
    void deleteById(long id);

}
