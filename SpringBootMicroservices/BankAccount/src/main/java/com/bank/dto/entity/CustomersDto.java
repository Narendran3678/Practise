package com.bank.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomersDto {
    @JsonIgnore
    private Long customerId;

    @NotNull
    @Size(min=5)
    @Pattern(regexp = "^[0-9a-zA-Z]*", message = "Special Character in CustomerName not allowed")
    private String customerName;

    @NotNull
    @Size(min=5)
    @Pattern(regexp = "^[\\w]*@[a-z]{2,5}.[a-z]{1,3}" , message = "Invalid Email Format, Sample(name1234@gmail.com)")
    private String emailId;
    
    @NotNull
    @Pattern(regexp = "^[0-9]*",message = "Mobile Number must Be Numbers")
    private String mobileNumber;

    private AccountsDto accounts;
}
