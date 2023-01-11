package com.demo.customerrewardsapp.service.impl;

import com.demo.customerrewardsapp.entity.Customer;
import com.demo.customerrewardsapp.exception.ResourceNotFoundException;
import com.demo.customerrewardsapp.repository.CustomerRepository;
import com.demo.customerrewardsapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
/**
 * 
 * Customer service business logic implementation
 * @author Ragu
 *
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;


    public Customer getCustomerById(long customerId) throws ResourceNotFoundException {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("CustomerId ::" + customerId));
    }

    public Customer createCustomer(Customer customer) {
        if(customerRepository.findById(customer.getCustomerId()).isPresent()){
            return customer;
        }
        return customerRepository.save(customer);
    }
}
