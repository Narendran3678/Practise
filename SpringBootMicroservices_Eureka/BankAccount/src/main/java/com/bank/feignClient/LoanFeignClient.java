package com.bank.feignClient;

import com.bank.dto.entity.LoansDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("loan-application")
public interface LoanFeignClient {
    @GetMapping(value="/bank/api/fetch",consumes = "application/json")
    public ResponseEntity<LoansDto> fetchLoanDetails(@RequestParam String mobileNumber);
}
