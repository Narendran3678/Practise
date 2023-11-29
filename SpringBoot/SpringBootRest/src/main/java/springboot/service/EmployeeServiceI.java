package springboot.service;

import springboot.entity.Employee;

import java.util.List;

public interface EmployeeServiceI {
    public List<Employee> findAll() ;
    public Employee find(long id);
    public Employee persist(Employee employee);
    public boolean delete(long id);
}
