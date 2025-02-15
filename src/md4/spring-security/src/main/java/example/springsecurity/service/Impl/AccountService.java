package example.springsecurity.service.Impl;

import example.springsecurity.model.Account;
import example.springsecurity.repository.IAccountRepository;
import example.springsecurity.service.IAccountService;
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
