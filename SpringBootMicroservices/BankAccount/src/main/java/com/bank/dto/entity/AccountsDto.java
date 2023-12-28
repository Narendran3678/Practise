package com.bank.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("account_number")
    private String accountnumber;

    @JsonProperty("account_type")
    private String accounttype;

    @JsonProperty("branch_address")
    private String branchAddress;
}
