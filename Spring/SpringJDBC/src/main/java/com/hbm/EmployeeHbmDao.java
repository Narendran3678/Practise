package com.hbm;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import com.entity.Employee;
import com.utils.HibernateUtils;

@Transactional
public class EmployeeHbmDao {

	private HibernateUtils hibernateUtils;
	private HibernateTemplate hibernateTemplate;
	
	public EmployeeHbmDao(HibernateUtils hibernateUtils) {
		this.hibernateUtils = hibernateUtils;
	}
	public List<Employee> getEnities() {
	
		Session session = hibernateUtils.getHibernateSession().openSession();
		List<Employee> employeeList= session.createQuery("from Employee",Employee.class).getResultList();
		return employeeList;
	}

	public Employee getEnity(Long id) {
		return null;
	}

	public boolean createEnity(Employee employee) {
		boolean insertStatus = false;
		
		Session session = hibernateUtils.getHibernateSession().openSession();
		Transaction transaction  = session.beginTransaction();
		session.persist(employee);
		transaction.commit();
		insertStatus=true;
		
		return insertStatus;
	}

	public boolean updateEnity(Employee employee, Long id) {
		boolean updateStatus = false;
		return updateStatus;
	}

	public boolean deleteEnity(Long id) {
		boolean deleteStatus = false;
		return deleteStatus;
	}
	public HibernateUtils getHibernateUtils() {
		return hibernateUtils;
	}
	public void setHibernateUtils(HibernateUtils hibernateUtils) {
		this.hibernateUtils = hibernateUtils;
	}

	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
