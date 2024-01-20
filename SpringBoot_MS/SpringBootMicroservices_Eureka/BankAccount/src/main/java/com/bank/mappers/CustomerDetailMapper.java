package com.bank.mappers;

import com.bank.dto.entity.*;

public class CustomerDetailMapper {
    public static CustomerDetailsDto AccCust_dto_to_CustomerDetailDto(CustomersDto customersDto, AccountsDto accountsDto, LoansDto loansDto, CardsDto cardsDto) {
        CustomerDetailsDto customerDetailsDto = new CustomerDetailsDto();
        customerDetailsDto.setCustomerName(customersDto.getCustomerName());
        customerDetailsDto.setEmailId(customersDto.getEmailId());
        customerDetailsDto.setMobilenumber(customersDto.getMobileNumber());
        if(accountsDto!=null)
            customerDetailsDto.setAccountsDto(accountsDto);
        if(loansDto!=null)
            customerDetailsDto.setLoansDto(loansDto);
        if(cardsDto!=null)
            customerDetailsDto.setCardDto(cardsDto);

        return customerDetailsDto;
    }
}
