package com.hbm;
import java.util.List;
import com.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class EmployeeJpaDao {
	private EntityManagerFactory entityManagerFactory;
	public EmployeeJpaDao() {

	}
	
	public List<Employee> getEnities() {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Employee> employeeList= entityManager.createQuery("from Employee",Employee.class).getResultList();
		return employeeList;
	}
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
}
