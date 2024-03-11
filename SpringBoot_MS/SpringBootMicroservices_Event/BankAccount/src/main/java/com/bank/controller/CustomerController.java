package com.bank.controller;

import com.bank.dto.entity.CustomerDetailsDto;
import com.bank.services.Intf.CustomerDetailServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerDetailServiceI customerDetailService;

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    //http://localhost:8080/bank/api/fetchCustomerDetails?mobileNumber=6385810492
    @GetMapping("/fetchCustomerDetails")
    public ResponseEntity<CustomerDetailsDto> getCustomerDetails(@RequestHeader("bank-corr-id") String correlationId,
                                                                 @RequestParam(value = "mobileNumber") String mobileNumber) {
        logger.debug("CustomerController getCustomerDetails");
        return ResponseEntity.status(HttpStatus.OK).body(customerDetailService.fetchCustomerDetail(correlationId,mobileNumber));
    }
}
