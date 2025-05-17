package example.spring_security_jwt_version2.service.Impl;

import example.spring_security_jwt_version2.model.User;
import example.spring_security_jwt_version2.model.UserPrincipal;
import example.spring_security_jwt_version2.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return new UserPrincipal(user.get().getUsername(),user.get().getPassword(),user.get().getRole());

        }
        return null;
    }
}
