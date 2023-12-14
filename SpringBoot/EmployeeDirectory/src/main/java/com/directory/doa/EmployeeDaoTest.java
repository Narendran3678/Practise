package com.directory.doa;
import com.directory.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public class EmployeeDaoTest {
    EntityManager entityManager;

    public void setup() {
        entityManager = getSessionFactoryJava();
    }

    public static void main(String args[]) {
        EmployeeDaoTest employeeDaoTest = new EmployeeDaoTest();
        employeeDaoTest.setup();
        //employeeDaoTest.findById();
        //employeeDaoTest.findAll();
        employeeDaoTest.delete();
    }
    public void findById()
    {
        Employee employee = entityManager.find(Employee.class,1L);
        System.out.println(employee);
    }
    public void findAll()
    {
        List<Employee> employee = entityManager.createQuery("from Employee",Employee.class).getResultList();
        System.out.println(employee);
    }
    public void delete()
    {
        EntityTransaction transaction =  entityManager.getTransaction();
        try {
            transaction.begin();
            Employee employee = entityManager.find(Employee.class, 4L);
            entityManager.remove(employee);
            transaction.commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            transaction.rollback();
        }
        finally {
            if(transaction!=null)
                transaction=null;
        }

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
