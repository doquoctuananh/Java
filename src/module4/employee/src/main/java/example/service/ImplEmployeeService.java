package example.service;

import example.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class ImplEmployeeService implements IEmployeeService {

    @Override
    public void createEmployee(Employee employee) {

    }

    @Override
    public Employee getEmployeeById(int id) {
        return null;
    }
}
