package com.bank.entity;

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
    private String accounttype;

    @Column(name="branchAddress")
    private String branchAddress;
}
