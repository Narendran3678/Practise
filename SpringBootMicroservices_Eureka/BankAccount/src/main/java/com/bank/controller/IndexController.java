package com.bank.controller;
import com.bank.config.AccountContactInfo;
import com.bank.config.AccountInfo;
import com.bank.dto.response.ResponseDto;
import com.bank.dto.entity.CustomersDto;
import com.bank.services.Intf.CustomersServiceI;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    AccountContactInfo accountContactInfo;

    @Autowired
    Environment environment;

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    //http://localhost:8081/bank/api
    //http://localhost:8081/bank/api/customers
    //http://localhost:8081/bank/swagger-ui/index.html
    //http://localhost:8081/bank/api-docs
    //java -jar Account-2023.1.jar --spring.profiles.active=prod   -> Command Line Argument
    //java -Dspring.profiles.active=prod -jar Account-2023.1.jar   -> JVM Argument

    @GetMapping
    public ResponseEntity<String> indexMethod(@RequestHeader("bank-corr-id") String correlationId) {
        return ResponseEntity.status(HttpStatus.OK).body("Welcome to Bank Account Service");
    }

    //http://localhost:8081/bank/api/customers
    @GetMapping("/customers")
    public ResponseEntity<List<CustomersDto>> getAllCustomer(@RequestHeader("bank-corr-id") String correlationId) {
        System.out.println("All Customer Fetch, CorrelationId["+correlationId+"]");
        return ResponseEntity.status(HttpStatus.OK).body(customersServiceI.findAll());
    }

    //http://localhost:8081/bank/api/customers/2
    @GetMapping(value = "/customers/{customerId}")
    public ResponseEntity<CustomersDto> getCustomersById(@RequestHeader("bank-corr-id") String correlationId,
                                                         @PathVariable("customerId") Long customerId) {
        System.out.println("Customer Id..."+customerId);
        return ResponseEntity.status(HttpStatus.OK).body(customersServiceI.findById(customerId));
    }

    //http://localhost:8081/bank/api/customers?mobileNumber=7092802533
    @GetMapping(value = "/customers",params="mobileNumber")
    public ResponseEntity<CustomersDto> getCustomersByMobileNumber(@RequestHeader("bank-corr-id") String correlationId,
                                                                   @RequestParam("mobileNumber") @Valid String mobileNumber) {
        System.out.println("Mobile Number..."+mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customersServiceI.findByMobileNumber(mobileNumber));
    }

    @PostMapping("/customers")
    public ResponseEntity<ResponseDto> createCustomer(@RequestHeader("bank-corr-id") String correlationId,
                                                      @Valid @RequestBody CustomersDto customersDto) {
        System.out.println("Customer Request..."+customersDto);
        customersDto = customersServiceI.persist(customersDto);
        ResponseDto dto = new ResponseDto(HttpStatus.CREATED.value(),"Customer ["+customersDto.getCustomerName()+"] Created", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @DeleteMapping("/customers")
    public ResponseEntity<ResponseDto> deleteCustomers(@RequestHeader("bank-corr-id") String correlationId,
                                                       @RequestParam("customerId") @Pattern(regexp = "^[0-9]*") Long customerId) {
        System.out.println("Customer Id..."+customerId);
        customersServiceI.delete(customerId);
        ResponseDto dto = new ResponseDto(HttpStatus.OK.value(),"Customer Deleted", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/contact-info")
    public ResponseEntity<AccountContactInfo> getAccountInfo(@RequestHeader("bank-corr-id") String correlationId) {
        return ResponseEntity.status(HttpStatus.OK).body(accountContactInfo);
    }


    @GetMapping("/system-info")
    public ResponseEntity<Map<String,String>> getSystemInfo(@RequestHeader("bank-corr-id") String correlationId) {
        Map<String,String> envInfo = new HashMap<>();
        envInfo.put("Java Version",environment.getProperty("java.version"));
        envInfo.put("OS Name",environment.getProperty("os.name"));
        envInfo.put("OS Version",environment.getProperty("os.version"));
        return ResponseEntity.status(HttpStatus.OK).body(envInfo);
    }
}
