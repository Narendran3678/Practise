package com.directory.doa;

import com.directory.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    private EntityManager entityManager;
    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }
    @Override
    public Employee saveOrMerge(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    @Override
    public List<Employee> findAll() {

        return entityManager.createQuery("from Employee",Employee.class).getResultList();
    }

    @Override
    public Employee findById(Long id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public boolean delete(Long id) {
        entityManager.remove(findById(id));
        return true;
    }
}
