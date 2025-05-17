package example.spring_security_jwt_version2.service;

import example.spring_security_jwt_version2.model.Role;

public interface IRoleService {
    Role findByName(String name);
}
