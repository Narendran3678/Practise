package com.bank.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="customers")
public class Customers extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customerid")
    private Long customerId;

    @Column(name="customername")
    private String customerName;

    @Column(name="emailid",unique = true)
    private String emailId;

    @Column(name="mobilenumber")
    private String mobilenumber;

    @Column(name="activeflag")
    private Integer activeflag;

    public Customers(String customerName, String emailId, String mobilenumber) {
        this.customerName = customerName;
        this.emailId = emailId;
        this.mobilenumber = mobilenumber;
    }
}
