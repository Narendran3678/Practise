package com.bank.services.impl;

import com.bank.dto.entity.AccountsDto;
import com.bank.entity.Accounts;
import com.bank.exceptionhandler.ResourceNotFoundException;
import com.bank.mappers.AccountsMapper;
import com.bank.repository.AccountsRepository;
import com.bank.services.Intf.AccountsServiceI;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountsServiceImpl implements AccountsServiceI {
    @Autowired
    AccountsRepository accountsRepository;
    @Override
    public List<AccountsDto> findAll() {
        List<Accounts> accountsList = accountsRepository.findAll();
        if(accountsList.size() > 0)
            return AccountsMapper.entityList_To_AccountsList_Dto(accountsList, new ArrayList<AccountsDto>());
        else
            return new ArrayList<>();
    }

    @Override
    public AccountsDto findById(Long customerId) {
        Optional<Accounts> accounts = accountsRepository.findById(customerId);
        if (accounts.isPresent())
            return AccountsMapper.entity_To_Account_Dto(accounts.get(), new AccountsDto());
        else {
            throw new ResourceNotFoundException("Account ["+customerId+"] not found");
        }
    }

    @Override
    public AccountsDto persist(AccountsDto accountsDto) {
        if(accountsDto!=null) {
            Accounts account = AccountsMapper.dto_To_Account_Entity(accountsDto,new Accounts());
            accountsRepository.save(account);
            return AccountsMapper.entity_To_Account_Dto(account,new AccountsDto());
        }
        else
            return new AccountsDto();
    }

    @Override
    public Boolean delete(Long customerId) {
        Optional<Accounts> accounts = accountsRepository.findById(customerId);
        if (accounts.isPresent()) {
            accountsRepository.delete(accounts.get());
        }
        else {
            throw new ResourceNotFoundException("Account ["+customerId+"] not found");
        }
        return true;
    }


}
