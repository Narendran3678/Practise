package com.directory.service;

import com.directory.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee saveOrMerge(Employee employee);
    public List<Employee> findAll();
    public Employee findById(Long id);
    public boolean delete(Long id);
}
