package com.bank.controller;
import com.bank.config.AccountInfo;
import com.bank.dto.response.ResponseDto;
import com.bank.dto.entity.CustomersDto;
import com.bank.services.Intf.CustomersServiceI;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Validated
public class IndexController {
    @Autowired
    CustomersServiceI customersServiceI;

    @Autowired
    AccountInfo accountInfo;

    @Autowired
    Environment environment;

    //http://localhost:8081/bank/api
    //http://localhost:8081/bank/api/customers
    //http://localhost:8081/bank/swagger-ui/index.html
    //http://localhost:8081/bank/api-docs
    //java -jar Account-2023.1.jar --spring.profiles.active=prod   -> Command Line Argument
    //java -Dspring.profiles.active=prod -jar Account-2023.1.jar   -> JVM Argument

    @GetMapping
    public ResponseEntity<String> indexMethod() {
        return ResponseEntity.status(HttpStatus.OK).body("Welcome to Bank Account Service");
    }

    //http://localhost:8081/bank/api/customers
    @GetMapping("/customers")
    public ResponseEntity<List<CustomersDto>> getAllCustomer() {
        System.out.println("All Customer Fetch");
        return ResponseEntity.status(HttpStatus.OK).body(customersServiceI.findAll());
    }

    //http://localhost:8081/bank/api/customers/2
    @GetMapping(value = "/customers/{customerId}")
    public ResponseEntity<CustomersDto> getCustomersById(@PathVariable("customerId") Long customerId) {
        System.out.println("Customer Id..."+customerId);
        return ResponseEntity.status(HttpStatus.OK).body(customersServiceI.findById(customerId));
    }

    //http://localhost:8081/bank/api/customers?mobileNumber=7092802533
    @GetMapping(value = "/customers",params="mobileNumber")
    public ResponseEntity<CustomersDto> getCustomersByMobileNumber(@RequestParam("mobileNumber")
                                                                       @Valid String mobileNumber) {
        System.out.println("Mobile Number..."+mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customersServiceI.findByMobileNumber(mobileNumber));
    }

    @PostMapping("/customers")
    public ResponseEntity<ResponseDto> createCustomer(@Valid @RequestBody CustomersDto customersDto) {
        System.out.println("Customer Request..."+customersDto);
        customersDto = customersServiceI.persist(customersDto);
        ResponseDto dto = new ResponseDto(HttpStatus.CREATED.value(),"Customer ["+customersDto.getCustomerName()+"] Created", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @DeleteMapping("/customers")
    public ResponseEntity<ResponseDto> deleteCustomers(@RequestParam("customerId") @Pattern(regexp = "^[0-9]*") Long customerId) {
        System.out.println("Customer Id..."+customerId);
        customersServiceI.delete(customerId);
        ResponseDto dto = new ResponseDto(HttpStatus.OK.value(),"Customer Deleted", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/account-info")
    public ResponseEntity<AccountInfo> getAccountInfo() {
        return ResponseEntity.status(HttpStatus.OK).body(accountInfo);
    }


    @GetMapping("/system-info")
    public ResponseEntity<Map<String,String>> getSystemInfo() {
        Map<String,String> envInfo = new HashMap<>();
        envInfo.put("Java Version",environment.getProperty("java.version"));
        envInfo.put("OS Name",environment.getProperty("os.name"));
        envInfo.put("OS Version",environment.getProperty("os.version"));
        return ResponseEntity.status(HttpStatus.OK).body(envInfo);
    }
}
