package com.bank.repository;

import com.bank.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AccountsRepository extends JpaRepository<Accounts,Long> {
}