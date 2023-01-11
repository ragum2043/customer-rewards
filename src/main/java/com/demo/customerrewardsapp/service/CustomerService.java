package com.demo.customerrewardsapp.service;

import com.demo.customerrewardsapp.entity.Customer;
import com.demo.customerrewardsapp.exception.ResourceNotFoundException;
/**
 * 
 * CustomerService to get and create customers
 * @author Ragu
 *
 */
public interface CustomerService {
    public Customer getCustomerById(long customerId) throws ResourceNotFoundException;
    public Customer createCustomer(Customer customer);
}
