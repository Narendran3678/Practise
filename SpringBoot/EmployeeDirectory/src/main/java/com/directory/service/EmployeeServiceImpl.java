package com.directory.service;

import com.directory.doa.EmployeeDao;
import com.directory.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDao employeeDao;

    @Transactional
    @Override
    public Employee saveOrMerge(Employee employee) {
        return employeeDao.saveOrMerge(employee);
    }

    @Transactional
    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Transactional
    @Override
    public Employee findById(Long id) {
        return employeeDao.findById(id);
    }

    @Transactional
    @Override
    public boolean delete(Long id) {
        return employeeDao.delete(id);
    }
}
