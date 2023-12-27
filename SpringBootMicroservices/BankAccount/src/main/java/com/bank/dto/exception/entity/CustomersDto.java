package com.bank.dto.exception.entity;

import com.bank.entity.Accounts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomersDto {
    private String customerName;

    private String emailId;

    private String mobilenumber;

    private AccountsDto accountsDto;
}
