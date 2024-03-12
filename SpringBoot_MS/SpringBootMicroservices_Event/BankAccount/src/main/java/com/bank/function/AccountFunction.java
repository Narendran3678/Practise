package com.bank.function;

import com.bank.services.Intf.CustomersServiceI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Consumer;

@Configuration
public class AccountFunction {
    @Bean
    public Consumer<String> updateCommunication(CustomersServiceI customersService) {
        return mobileNumber -> {
            System.out.println("Updating Communication status for the account number : " + mobileNumber);
            customersService.updateCommunication(mobileNumber);
        };
    }
}
