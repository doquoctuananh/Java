package example.springsecurity.configuration.security;

import example.springsecurity.common.EncryptPassword;
import example.springsecurity.model.Account;
import example.springsecurity.model.Role;
import example.springsecurity.repository.IAccountRepository;
import example.springsecurity.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

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
        if(roleRepository.findRoleByName("ROLE_ADMIN") == null ){
            Role role_admin = new Role("ROLE_ADMIN");
            roleRepository.save(role_admin);
        }

        if(roleRepository.findRoleByName("ROLE_USER") == null){
            Role role_user = new Role("ROLE_USER");
            roleRepository.save(role_user);
        }

        //them admin
        if(accountRepository.findAccountByUsername("admin")==null){
            Account admin = new Account();
            admin.setUsername("admin");
            admin.setPassword(EncryptPassword.encryptPassWord("admin"));
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findRoleByName("ROLE_ADMIN"));
            roles.add(roleRepository.findRoleByName("ROLE_USER"));
            admin.setRoles(roles);
            accountRepository.save(admin);
        }

        //them user
        if(accountRepository.findAccountByUsername("customer")==null){
            Account customer = new Account();
            customer.setUsername("customer");
            customer.setPassword(EncryptPassword.encryptPassWord("123456"));
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findRoleByName("ROLE_USER"));
            customer.setRoles(roles);
            accountRepository.save(customer);
        }

    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
