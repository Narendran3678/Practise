package com.directory.service;

import com.directory.doa.EmployeeDao;
import com.directory.doa.EmployeeRepository;
import com.directory.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    EmployeeRepository employeeRepository;

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

    @Override
    public List<Employee> findAllByOrderByFirstName() {
        return employeeRepository.findAllByOrderByFirstName();
    }

    @Override
    public Page<Employee> findAllByPage(int pageNum, String sortFieldName, String sortDirection) {
        int pagePerEmployee = 3;
        Pageable pageable = PageRequest.of(pageNum-1,pagePerEmployee,
                sortDirection.equalsIgnoreCase("ASC") ? Sort.by(sortFieldName).ascending() :Sort.by(sortFieldName).descending() );
        return employeeRepository.findAll(pageable);
    }


}
