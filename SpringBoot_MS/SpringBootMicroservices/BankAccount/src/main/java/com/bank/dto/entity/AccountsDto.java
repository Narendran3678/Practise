package com.bank.dto.entity;

import com.bank.constant.BankConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountsDto {
    @JsonIgnore
    private Long customerId;

    private String accountnumber;

    private BankConstants.ACCOUNT_TYPE accounttype;

    private String branchAddress;
}
