package com.demo.customerrewardsapp.entity;

import lombok.Data;

import javax.persistence.*;

import java.sql.Timestamp;

/**
 * 
 * Transactions entiry class
 * @author Ragu
 *
 */
@Data
@Entity
@Table(name = "TRANSACTIONS")
public class Transactions {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    private Long transactionId;

    @Column(name="CUSTOMER_ID")
    private long customerId;

    @Column(name = "TRANSACTION_DATE")
    private Timestamp date;

    @Column(name = "AMOUNT")
    private double amount;
}
