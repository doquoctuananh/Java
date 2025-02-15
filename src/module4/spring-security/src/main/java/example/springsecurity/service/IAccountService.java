package example.springsecurity.service;

import example.springsecurity.model.Account;

public interface IAccountService {
    Account findAccountByUsername(String username);
}
