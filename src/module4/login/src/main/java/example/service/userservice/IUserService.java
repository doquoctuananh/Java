package example.service.userservice;

import example.model.Account;
import example.model.User;

public interface IUserService {
    User loginUser(Account account);
}
