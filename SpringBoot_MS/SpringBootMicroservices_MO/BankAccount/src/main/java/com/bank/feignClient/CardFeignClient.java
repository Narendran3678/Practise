package com.bank.feignClient;

import com.bank.dto.entity.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="card-application",fallback = CardFallback.class)
public interface CardFeignClient {
    @GetMapping(value="/bank/api/fetch",consumes = "application/json")
    public ResponseEntity<CardsDto> fetchCardDetails(@RequestHeader("bank-corr-id") String correlationId,@RequestParam String mobileNumber);
}
