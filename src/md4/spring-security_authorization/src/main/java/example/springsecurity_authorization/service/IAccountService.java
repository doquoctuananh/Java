package example.springsecurity_authorization.service;

import example.springsecurity_authorization.model.Account;

public interface IAccountService {
    Account findAccountByUsername(String username);
}
