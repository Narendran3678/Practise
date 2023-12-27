package com.bank.controller;
import com.bank.dto.exception.ResponseDto;
import com.bank.dto.entity.CustomersDto;
import com.bank.services.Intf.CustomersServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.management.relation.RelationServiceNotRegisteredException;
import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("/api")
public class IndexController {
    @Autowired
    CustomersServiceI customersServiceI;

    //http://localhost:8081/bank/api
    @RequestMapping(value={"","/"})
    public ResponseEntity<String> indexMethod() {
        return ResponseEntity.status(HttpStatus.OK).body("Welcome to Bank Account Service");
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomersDto>> getAllCustomer() {
        return ResponseEntity.status(HttpStatus.OK).body(customersServiceI.findAll());
    }
    @GetMapping("/customers/{customerId}")
    public ResponseEntity<CustomersDto> getCustomers(@PathVariable("customerId") Long customerId) {
        System.out.println("Customer Id..."+customerId);
        return ResponseEntity.status(HttpStatus.OK).body(customersServiceI.findById(customerId));
    }

    @PostMapping("/customers")
    public ResponseEntity<ResponseDto> createCustomer(@RequestBody CustomersDto customersDto) {
        System.out.println("Customer Request..."+customersDto);
        customersDto = customersServiceI.persist(customersDto);
        ResponseDto dto = new ResponseDto(HttpStatus.CREATED.value(),"Customer ["+customersDto.getCustomerName()+"] Created", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<ResponseDto> deleteCustomers(@PathVariable("customerId") Long customerId) {
        System.out.println("Customer Id..."+customerId);
        customersServiceI.delete(customerId);
        ResponseDto dto = new ResponseDto(HttpStatus.OK.value(),"Customer Deleted", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
