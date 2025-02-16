package com.example.demo.service.security;


import com.example.demo.model.Account;

public interface AccountService {
    Account findUserByEmail(String email);
}
