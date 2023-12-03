package src.main.test;

import jakarta.persistence.*;
import org.aspectj.lang.annotation.Before;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springboot.dao.EmployeeDaoI;
import springboot.dao.EmployeeDaoImpl;
import springboot.entity.Employee;
import springboot.entity.Role;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Properties;

public class EmployeeDaoTest {
    EntityManager entityManager;
    @BeforeEach
    public void setup() {
        entityManager = getSessionFactoryJava();

    }
    @Test
    public void bcryptTest() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("naren"));
        System.out.println(encoder.encode("divya"));
        boolean narenPassword = encoder.matches("naren","$2a$10$GeygHXXSB3jmA/w9GYidbO1oeENJ5.d1pEnGyHd37lZJfXF.9AFMG");
        boolean divyaPassword = encoder.matches("divya","$2a$10$06.qZNCKJYoQmSUqJUTLMe8tUgXBHZR6WCO6pnHaZp08Jfqk4gd1a");
        System.out.println(narenPassword +"="+divyaPassword);
    }
   // @Test
    public void employeeFindAllMethod() {
      EmployeeDaoI daoImpl = new EmployeeDaoImpl(getSessionFactoryJava());
      daoImpl.findAll().forEach( System.out::println);
    }
    //@Test
    public void employeeCreateMethod() {
        EntityTransaction transaction = null;
        try {
            EmployeeDaoI daoImpl = new EmployeeDaoImpl(entityManager);
            transaction = entityManager.getTransaction();
            transaction.begin();
            Employee employee = new Employee("Jake", "Cabe", "9812345667", "jake@gmail.com", 9000.0);
            Role role = new Role(1, "Admin");
            employee.setRole(Arrays.asList(role));
            daoImpl.persist(employee);
            transaction.commit();
        }
        catch (Exception e) {
            if(transaction!=null)
                transaction.rollback();
            e.printStackTrace();
        }
    }
    @AfterEach
    public void close(){
        if(entityManager!=null)
            entityManager.close();
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
