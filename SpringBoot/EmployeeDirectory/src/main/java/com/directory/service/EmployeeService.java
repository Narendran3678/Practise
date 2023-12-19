package com.directory.service;

import com.directory.entity.Employee;
import org.springframework.data.domain.Page;
import java.util.List;

public interface EmployeeService {
    public Employee saveOrMerge(Employee employee);
    public List<Employee> findAll();
    public Employee findById(Long id);
    public boolean delete(Long id);
    public List<Employee> findAllByOrderByFirstName();
    public Page<Employee> findAllByPage(int pageNum,String sortFieldName,String sortDirection);
    public List<Employee> findByAage(Integer age);
    public Integer updateSalary(Integer age);
}
