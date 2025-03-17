package example.spring_role_authorization.security;

import example.spring_role_authorization.common.CustomBcryptPasswordUtils;
import example.spring_role_authorization.model.Account;
import example.spring_role_authorization.model.Roles;
import example.spring_role_authorization.repository.IAccountRepository;
import example.spring_role_authorization.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataSeedingListener implements ApplicationListener<ApplicationEvent> {
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private IAccountRepository accountRepository;
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(roleRepository.findByName("ROLE_ADMIN") == null) {
            roleRepository.save(new Roles("ROLE_ADMIN"));
        }

        if(roleRepository.findByName("ROLE_USER") == null) {
            roleRepository.save(new Roles("ROLE_USER"));
        }

        if(accountRepository.findByUsername("admin") == null) {
            Account admin = new Account();
            admin.setUsername("admin");
            admin.setPassword(CustomBcryptPasswordUtils.customBcryptPasswordEncoder("admin"));
            admin.setAddress("Nghe an");
            admin.setBirthday(LocalDate.parse("2001-01-01"));
            admin.setEmail("admin@gmail.com");
            admin.setGender(false);
            admin.setPhone("0987654321");
            admin.setRoles(roleRepository.findByName("ROLE_ADMIN"));
            accountRepository.save(admin);
        }
        if(accountRepository.findByUsername("customer1") == null) {
            Account customer = new Account();
            customer.setUsername("customer1");
            customer.setPassword(CustomBcryptPasswordUtils.customBcryptPasswordEncoder("123456"));
            customer.setAddress("Ha Noi");
            customer.setBirthday(LocalDate.parse("2001-12-12"));
            customer.setEmail("quocanhanh1204@gmail.com");
            customer.setGender(true);
            customer.setPhone("0987654321");
            customer.setRoles(roleRepository.findByName("ROLE_USER"));
            accountRepository.save(customer);
        }

    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
