package example.spring_role_authorization.service.Impl;

import example.spring_role_authorization.model.Account;
import example.spring_role_authorization.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomerDetailsUser implements UserDetailsService {
    @Autowired
    private IAccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = accountRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException(username);
        }
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRoles().getName()));
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
