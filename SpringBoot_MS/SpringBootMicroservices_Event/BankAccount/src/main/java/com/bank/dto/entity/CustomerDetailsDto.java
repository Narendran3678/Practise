package com.bank.dto.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDetailsDto {

    @JsonProperty("Customer-Name")
    private String customerName;
    @JsonProperty("Email-Id")
    private String emailId;
    @JsonProperty("Mobile-Number")
    private String mobilenumber;
    @JsonProperty("Account-Info")
    private AccountsDto accountsDto;
    @JsonProperty("Loan-Info")
    private LoansDto loansDto;
    @JsonProperty("Card-Info")
    private CardsDto cardDto;
    @JsonProperty("Communication_Switch")
    private Boolean communicationSwitch;

}
