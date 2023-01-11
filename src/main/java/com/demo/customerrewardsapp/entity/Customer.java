package com.demo.customerrewardsapp.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 
 * Customer entiry class
 * @author Ragu
 *
 */
@Data
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private long customerId;
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    @Column(name = "Email")
    private String email;
}

