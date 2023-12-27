package com.bank.test;

import com.bank.entity.Accounts;
import com.bank.entity.Customers;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CustomerAccountTest {
    static EntityManager entityManager;
    public static void main(String[] args) {
        createAccount();
    }
    public static void createAccount() {
        EntityTransaction transaction =  null;
        EntityManager factory = getSessionFactoryJava();
        try {
            transaction = factory.getTransaction();
            transaction.begin();
            Customers customer = new Customers("Divya","Divya@gmail.com","8220021216");
            customer.setCreatedBy("Naren");
            customer.setModifiedBy("Naren");
            factory.persist(customer);
            Accounts accounts = new Accounts(customer.getCustomerId(),"232144","SAVINGS","CHENNAI");
            factory.persist(accounts);
            transaction.commit();
        }
        catch (Exception e) {
            if(transaction!=null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if(factory!=null)
                factory.close();
        }
    }
    public static EntityManager getSessionFactoryJava() {
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
