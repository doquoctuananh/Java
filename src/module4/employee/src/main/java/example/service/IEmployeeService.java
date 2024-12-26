package example.service;

import example.model.Employee;

public interface IEmployeeService {
    void createEmployee(Employee employee);
    Employee getEmployeeById(int id);
}
