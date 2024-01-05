package com.bank.test;

import com.bank.constant.BankConstants;
import com.bank.entity.Accounts;
import com.bank.entity.Customers;
import com.bank.utils.Utility;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Random;

public class CustomerAccountTest {
    static EntityManager entityManager;
    public static void main(String[] args) {
        createAccount();
        //accountNumberGenerator();
    }
    public static void accountNumberGenerator() {
        Random rand = new Random();
        StringBuilder card = new StringBuilder();
        for (int i = 0; i < 14; i++)
        {
            int n = rand.nextInt(10);
            card .append(Integer.toString(n));
        }
        System.out.println(card);
    }
    public static void createAccount() {
        EntityTransaction transaction =  null;
        EntityManager factory = getSessionFactoryJava();
        try {
            transaction = factory.getTransaction();
            transaction.begin();
            Customers customer = new Customers("Khadar","khadar@gmail.com","6768856543");
            customer.setCreatedBy("Khadar");
            customer.setModifiedBy("Khadar");
            factory.persist(customer);
            Accounts accounts = new Accounts(customer.getCustomerId(), Utility.getRandomAccountNumber(), BankConstants.ACCOUNT_TYPE.SAVINGS,"CHENNAI");
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
