package com.bank.services.Intf;


import com.bank.dto.entity.CustomersDto;

import javax.management.relation.RelationServiceNotRegisteredException;
import java.util.List;

public interface CustomersServiceI {
    public List<CustomersDto> findAll();
    public CustomersDto findById(Long customerId) ;
    public CustomersDto persist(CustomersDto customersDto);
    public Boolean delete(Long customerId);
    public CustomersDto findByMobileNumber(String mobileNumber) ;
}
