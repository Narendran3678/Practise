package springboot.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.dao.EmployeeDaoI;
import springboot.entity.Employee;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI {
    private final EmployeeDaoI employeeDao;
    @Autowired
    public EmployeeServiceImpl(EmployeeDaoI employeeDao) {
        this.employeeDao=employeeDao;
    }
    @Transactional
    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Transactional
    @Override
    public Employee find(long id) {
        return employeeDao.find(id);
    }

    @Transactional
    @Override
    public Employee persist(Employee employee) {
        return employeeDao.persist(employee);
    }

    @Transactional
    @Override
    public boolean delete(long id) {
        return employeeDao.delete(id);
    }
}
