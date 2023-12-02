package src.main.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.junit.jupiter.api.Test;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import springboot.dao.EmployeeDaoI;
import springboot.dao.EmployeeDaoImpl;
import springboot.entity.Employee;
import springboot.entity.Role;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Properties;

public class EmployeeDaoTest {
    EntityManager entityManager;

   // @Test
    public void employeeFindAllMethod() {
      EmployeeDaoI daoImpl = new EmployeeDaoImpl(getSessionFactoryJava());
      daoImpl.findAll().forEach( System.out::println);
    }
    @Test
    public void employeeCreateMethod() {
        EmployeeDaoI daoImpl = new EmployeeDaoImpl(getSessionFactoryJava());
        //String firstName, String lastName, String phoneNumber, String emailId, Double salary
        Employee employee = new Employee("Jake","Cabe","9812345667","jake@gmail.com",9000.0);
        Role role = new Role(1,"Admin");
        employee.setRole(Arrays.asList(role));

        daoImpl.persist(employee);
    }
    public EntityManager getSessionFactoryJava() {
        EntityManagerFactory factory = null;
        if (entityManager == null) {
            try {
                factory = Persistence.createEntityManagerFactory("persistence-xml");
                entityManager = factory.createEntityManager();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return entityManager;
    }

}
