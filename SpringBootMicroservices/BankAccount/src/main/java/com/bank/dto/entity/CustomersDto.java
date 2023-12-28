package com.bank.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomersDto {
    @JsonIgnore
    private Long customerId;
    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("email_id")
    private String emailId;

    @JsonProperty("mobile_number")
    private String mobilenumber;

    @JsonProperty("account_info")
    private AccountsDto accounts;
}
