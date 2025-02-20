package example.exam_module4.security;

import example.exam_module4.common.CustomBcryptPassword;
import example.exam_module4.model.Account;
import example.exam_module4.model.Role;
import example.exam_module4.repository.IAccountRepositoty;
import example.exam_module4.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private IAccountRepositoty accountRepositoty;

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(roleRepository.findRoleByName("ROLE_ADMIN") == null){
            roleRepository.save(new Role("ROLE_ADMIN"));
        }
        if(roleRepository.findRoleByName("ROLE_USER") == null){
            roleRepository.save(new Role("ROLE_USER"));
        }

        if(accountRepositoty.findAccountByuserName("admin") == null){
            Account admin = new Account();
            admin.setUserName("admin");
            admin.setPassword(CustomBcryptPassword.customeBcryptPassword("admin"));
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findRoleByName("ROLE_ADMIN"));
            admin.setRoles(roles);
            accountRepositoty.save(admin);
        }

        if(accountRepositoty.findAccountByuserName("customer") == null){
            Account customer = new Account();
            customer.setUserName("customer");
            customer.setPassword(CustomBcryptPassword.customeBcryptPassword("123"));
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findRoleByName("ROLE_USER"));
            customer.setRoles(roles);
            accountRepositoty.save(customer);
        }

    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
