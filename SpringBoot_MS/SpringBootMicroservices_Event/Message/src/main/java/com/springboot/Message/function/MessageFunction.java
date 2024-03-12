package com.springboot.Message.function;

import com.springboot.Message.dto.AccountMsgDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.function.Function;

@Configuration
public class MessageFunction {
    @Bean
    public Function<AccountMsgDto,AccountMsgDto> email() {
        return accountsMsgDto -> {
            System.out.println("Sending EMAIL with the details : " +  accountsMsgDto.toString());
            return accountsMsgDto;
        };
    }

    @Bean
    public Function<AccountMsgDto,String> sms() {
        return accountsMsgDto -> {
            System.out.println("Sending SMS with the details : " +  accountsMsgDto.toString());
            return accountsMsgDto.mobileNumber();
        };
    }
}
