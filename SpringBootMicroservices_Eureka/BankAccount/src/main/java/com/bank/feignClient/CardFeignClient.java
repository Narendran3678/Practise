package com.bank.feignClient;

import com.bank.dto.entity.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("card-application")
public interface CardFeignClient {
    @GetMapping(value="/bank/api/fetch",consumes = "application/json")
    public ResponseEntity<CardsDto> fetchCardDetails(@RequestParam String mobileNumber);
}
