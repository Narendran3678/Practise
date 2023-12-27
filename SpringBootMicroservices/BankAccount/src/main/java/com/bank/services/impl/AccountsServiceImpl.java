package com.bank.services.impl;

import com.bank.dto.exception.entity.AccountsDto;
import com.bank.dto.exception.entity.CustomersDto;
import com.bank.entity.Accounts;
import com.bank.entity.Customers;
import com.bank.mappers.AccountsMapper;
import com.bank.mappers.CustomersMapper;
import com.bank.services.Intf.AccountsServiceI;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountsServiceImpl implements AccountsServiceI {
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<AccountsDto> findAll() {
        List<Accounts> accountsList = entityManager.createQuery("from Accounts",Accounts.class).getResultList();
        if(accountsList.size() > 0)
            return AccountsMapper.entityList_To_AccountsList_Dto(accountsList, new ArrayList<AccountsDto>());
        else
            return new ArrayList<>();
    }

    @Override
    public AccountsDto findById(Long customerId) {
        Accounts accounts = entityManager.find(Accounts.class,customerId);
        if(accounts!=null)
            return AccountsMapper.entity_To_Account_Dto(accounts,new AccountsDto());
        else
            return new AccountsDto();
    }

    @Override
    public AccountsDto persist(AccountsDto dto) {
        return null;
    }

    @Override
    public Boolean delete(Long customerId) {
        return null;
    }


}
