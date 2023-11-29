package springboot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springboot.entity.Employee;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDaoI {
    private final EntityManager entityManager;
    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> employeesList = entityManager.createQuery("from Employee", Employee.class);
        return employeesList.getResultList();
    }
    @Override
    public Employee find(long id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public Employee persist(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public boolean delete(long id) {
        entityManager.remove(id);
        return true;
    }

}
