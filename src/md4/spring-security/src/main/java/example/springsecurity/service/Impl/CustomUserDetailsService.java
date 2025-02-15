package example.springsecurity.service.Impl;

import example.springsecurity.model.Account;
import example.springsecurity.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IAccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findAccountByUsername(username);
        if (account == null) {
             throw new UsernameNotFoundException(username);
        }
        List<GrantedAuthority> grantedAuthorities = account.getRoles().stream().map(
                role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return new User(account.getUsername(), account.getPassword(), grantedAuthorities);
    }
}
