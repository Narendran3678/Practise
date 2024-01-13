package com.bank.services.Intf;

import com.bank.dto.entity.CustomerDetailsDto;

public interface CustomerDetailServiceI {
    public CustomerDetailsDto fetchCustomerDetail(String mobileNumber) ;
}
