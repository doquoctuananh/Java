package example.springsecurity_authorization.security;

import example.springsecurity_authorization.common.CustomBCryptPasswordEncoder;
import example.springsecurity_authorization.model.Account;
import example.springsecurity_authorization.model.Role;
import example.springsecurity_authorization.repository.IAccountRepository;
import example.springsecurity_authorization.repository.IRoleRepository;
import example.springsecurity_authorization.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //them role
        if(roleRepository.findRoleByRoleName("ROLE_ADMIN") == null){
            Role role_admin = new Role("ROLE_ADMIN");
            roleRepository.save(role_admin);
        }

        if(roleRepository.findRoleByRoleName("ROLE_USER") == null){
            Role role_user = new Role("ROLE_USER");
            roleRepository.save(role_user);
        }

        // them admin
        if(accountRepository.findAccountByUsername("admin") == null){
            Account account_admin = new Account();
            account_admin.setUsername("admin");
            account_admin.setPassword(CustomBCryptPasswordEncoder.customeBcryptPasswordEncoder("admin"));
            account_admin.setBirthday(LocalDate.parse("2001/04/12", DateTimeFormatter.ofPattern("yyyy/MM/dd")));
            account_admin.setEmail("quocanhanh1204@gmail.com");
            account_admin.setPhone("123456789");

            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findRoleByRoleName("ROLE_ADMIN"));
            account_admin.setRoles(roles);
            accountRepository.save(account_admin);
        }

        //them user
        if(accountRepository.findAccountByUsername("customer") == null){
            Account account_user = new Account();
            account_user.setUsername("customer");
            account_user.setPassword(CustomBCryptPasswordEncoder.customeBcryptPasswordEncoder("123"));
            account_user.setBirthday(LocalDate.parse("2001/02/18",DateTimeFormatter.ofPattern("yyyy/MM/dd")));
            account_user.setEmail("thao@gmail.com");
            account_user.setPhone("123456789");

            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findRoleByRoleName("ROLE_USER"));
            account_user.setRoles(roles);
            accountRepository.save(account_user);
        }
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
