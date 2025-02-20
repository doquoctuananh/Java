package example.springsecurity_authorization.service.Impl;

import example.springsecurity_authorization.model.Account;
import example.springsecurity_authorization.repository.IAccountRepository;
import example.springsecurity_authorization.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public Account findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }
}
