package com.bank.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountsDto {
    private Long customerId;

    private String accountnumber;

    private String accounttype;

    private String branchAddress;
}
