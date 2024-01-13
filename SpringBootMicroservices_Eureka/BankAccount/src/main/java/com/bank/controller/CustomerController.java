package com.bank.controller;

import com.bank.dto.entity.CustomerDetailsDto;
import com.bank.services.Intf.CustomerDetailServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerDetailServiceI customerDetailService;

    //http://localhost:8080/bank/api/fetchCustomerDetails?mobileNumber=6385810492
    @GetMapping("/fetchCustomerDetails")
    public ResponseEntity<CustomerDetailsDto> getCustomerDetails(@RequestParam(value = "mobileNumber") String mobileNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(customerDetailService.fetchCustomerDetail(mobileNumber));
    }
}
