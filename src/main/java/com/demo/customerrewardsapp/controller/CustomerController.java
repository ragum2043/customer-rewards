package com.demo.customerrewardsapp.controller;

import com.demo.customerrewardsapp.entity.Customer;
import com.demo.customerrewardsapp.exception.ResourceNotFoundException;
import com.demo.customerrewardsapp.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(value="/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") long customerId)  throws ResourceNotFoundException {
        Customer customer = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.OK);
    }
}
