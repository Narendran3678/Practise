package com.bank.controller;
import com.bank.dto.exception.entity.CustomersDto;
import com.bank.services.Intf.AccountsServiceI;
import com.bank.services.Intf.CustomersServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.management.relation.RelationServiceNotRegisteredException;
import java.util.List;
@RestController
@RequestMapping("/api")
public class IndexController {
    @Autowired
    CustomersServiceI customersServiceI;
    @Autowired
    AccountsServiceI accountsServiceI;

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
    public ResponseEntity<CustomersDto> getCustomers(@PathVariable("customerId") Long customerId) throws RelationServiceNotRegisteredException {
        System.out.println("Customer Id..."+customerId);
        return ResponseEntity.status(HttpStatus.OK).body(customersServiceI.findById(customerId));
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomersDto> createCustomer(@RequestBody CustomersDto customersDto) {
        return null;
    }
}
