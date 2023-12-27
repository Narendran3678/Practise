package com.bank.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

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

    @Column(name="branchaddress")
    private String branchAddress;

}
