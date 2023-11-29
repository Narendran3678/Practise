package springboot.dao;
import springboot.entity.Employee;

import java.util.*;
public interface EmployeeDaoI {
    public List<Employee> findAll() ;
    public Employee find(long id);
    public Employee persist(Employee employee);
    public boolean delete(long id);
}
