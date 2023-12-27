package com.bank.services.impl;

import com.bank.constant.BankConstants;
import com.bank.dto.exception.entity.CustomersDto;
import com.bank.entity.Accounts;
import com.bank.entity.Customers;
import com.bank.exceptionhandler.ResourceNotFoundException;
import com.bank.mappers.CustomersMapper;
import com.bank.repository.AccountsRepository;
import com.bank.repository.CustomersRepository;
import com.bank.services.Intf.CustomersServiceI;
import com.bank.utils.Utility;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomersServiceImpl implements CustomersServiceI {

    @Autowired
    CustomersRepository customersRepository;
    @Autowired
    AccountsRepository accountsRepository;
    @Value("${branch_address}")
    String branchAddress;
    @Override
    public List<CustomersDto> findAll() {
        List<Customers> customersList = customersRepository.findAll();
        if(!customersList.isEmpty())
            return CustomersMapper.entityList_To_CustomerList_Dto(customersList, new ArrayList<CustomersDto>());
        else
            return new ArrayList<>();
    }

    @Override
    public CustomersDto findById(Long customerId)   {
        Optional<Customers> customer = customersRepository.findById(customerId);
        if(customer.isPresent())
            return CustomersMapper.entity_To_Customer_Dto(customer.get(), new CustomersDto());
        else {
            throw new ResourceNotFoundException("Customer ["+customerId+"] not found");
        }
    }
    @Transactional
    @Override
    public CustomersDto persist(CustomersDto customersDto) {
        Customers customers = CustomersMapper.dto_To_Customer_Entity(customersDto,new Customers());
        customers.setCreatedBy("ADMIN");
        customers.setModifiedBy("ADMIN");
        customersRepository.save(customers);

        Accounts accounts = new Accounts();
        accounts.setCustomerId(customers.getCustomerId());
        accounts.setAccounttype(BankConstants.ACCOUNT_TYPE.SAVINGS.name());
        accounts.setAccountnumber(Utility.getRandomAccountNumber());
        accounts.setBranchAddress(branchAddress);
        accounts.setCreatedBy("ADMIN");
        accounts.setModifiedBy("ADMIN");
        accountsRepository.save(accounts);
        return CustomersMapper.entity_AccountCustomer_Map_To_CustomerDto(customers,accounts,new CustomersDto());
    }
    @Transactional
    @Override
    public Boolean delete(Long customerId) {
        return null;
    }

}
