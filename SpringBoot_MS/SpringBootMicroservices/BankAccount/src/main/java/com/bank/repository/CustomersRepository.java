package com.bank.repository;

import com.bank.entity.Accounts;
import com.bank.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomersRepository extends JpaRepository<Customers,Long> {
    Optional<Customers> findBymobilenumber(String mobilenumber);
}
