package com.bank.dto.entity;

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
