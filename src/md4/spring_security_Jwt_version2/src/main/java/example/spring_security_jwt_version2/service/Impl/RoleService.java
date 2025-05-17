package example.spring_security_jwt_version2.service.Impl;

import example.spring_security_jwt_version2.model.Role;
import example.spring_security_jwt_version2.repository.IRoleRepository;
import example.spring_security_jwt_version2.repository.IUserRepository;
import example.spring_security_jwt_version2.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
