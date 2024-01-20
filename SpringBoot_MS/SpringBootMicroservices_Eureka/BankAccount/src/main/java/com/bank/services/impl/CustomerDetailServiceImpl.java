package com.bank.services.impl;

import com.bank.dto.entity.*;
import com.bank.feignClient.CardFeignClient;
import com.bank.feignClient.LoanFeignClient;
import com.bank.mappers.CustomerDetailMapper;
import com.bank.services.Intf.AccountsServiceI;
import com.bank.services.Intf.CustomerDetailServiceI;
import com.bank.services.Intf.CustomersServiceI;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerDetailServiceImpl implements CustomerDetailServiceI {

    @Autowired
    private AccountsServiceI accountsService;
    @Autowired
    private CustomersServiceI customersService;
    @Autowired
    private CardFeignClient cardFeignClient;
    @Autowired
    private LoanFeignClient loanFeignClient;
    @Override
    public CustomerDetailsDto fetchCustomerDetail(String correlationId,String mobileNumber) {

        CustomersDto customersDto = customersService.findByMobileNumber(mobileNumber);
        AccountsDto accountDto = accountsService.findById(customersDto.getCustomerId());
        LoansDto loanDto = loanFeignClient.fetchLoanDetails(correlationId,mobileNumber).getBody();
        System.out.println("Loan..."+loanDto);
        CardsDto cardsDto = cardFeignClient.fetchCardDetails(correlationId,mobileNumber).getBody();
        System.out.println("Card..."+cardsDto);
        CustomerDetailsDto customerDetailsDto = CustomerDetailMapper.AccCust_dto_to_CustomerDetailDto(customersDto,accountDto,loanDto, cardsDto);
        return customerDetailsDto;
    }
}
