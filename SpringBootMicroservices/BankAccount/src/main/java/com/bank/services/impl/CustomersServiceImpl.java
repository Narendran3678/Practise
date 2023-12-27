package com.bank.services.impl;

import com.bank.dto.exception.entity.CustomersDto;
import com.bank.entity.Customers;
import com.bank.exceptionhandler.ResourceNotFoundException;
import com.bank.mappers.CustomersMapper;
import com.bank.services.Intf.CustomersServiceI;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RelationServiceNotRegisteredException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomersServiceImpl implements CustomersServiceI {
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<CustomersDto> findAll() {
        List<Customers> customersList = entityManager.createQuery("from Customers",Customers.class).getResultList();
        if(customersList.size() > 0)
            return CustomersMapper.entityList_To_CustomerList_Dto(customersList, new ArrayList<CustomersDto>());
        else
            return new ArrayList<>();
    }

    @Override
    public CustomersDto findById(Long customerId)   {
        Customers customer = entityManager.find(Customers.class,customerId);
        if(customer != null)
            return CustomersMapper.entity_To_Customer_Dto(customer, new CustomersDto());
        else {
            throw new ResourceNotFoundException("Customer ["+customerId+"] not found");
        }
    }

    @Override
    public CustomersDto persist(CustomersDto customersDto) {
        return null;
    }

    @Override
    public Boolean delete(Long customerId) {
        return null;
    }

}
