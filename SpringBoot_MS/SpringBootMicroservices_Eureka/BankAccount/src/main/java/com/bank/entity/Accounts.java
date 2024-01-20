package com.bank.entity;

import com.bank.constant.BankConstants;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="accounts")
public class Accounts extends BaseEntity {

    @Id
    @Column(name="customerid")
    private Long customerId;

    @Column(name="accountnumber")
    private String accountnumber;

    @Column(name="accounttype")
    @Enumerated(EnumType.STRING)
    private BankConstants.ACCOUNT_TYPE accountType;

    @Column(name="branchaddress")
    private String branchAddress;

}
