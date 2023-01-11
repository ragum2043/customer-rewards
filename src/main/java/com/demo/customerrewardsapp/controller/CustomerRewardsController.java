package com.demo.customerrewardsapp.controller;

import com.demo.customerrewardsapp.exception.ResourceNotFoundException;
import com.demo.customerrewardsapp.model.CustomerRewards;
import com.demo.customerrewardsapp.repository.CustomerRepository;
import com.demo.customerrewardsapp.service.CustomerRewardsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * CustomerRewards Controller class is used to retrieve the rewards for requested customer
 * @author Ragu
 *
 */
@RestController
@RequestMapping("/rewards/customer")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerRewardsController {

    private final CustomerRewardsService customerRewardsService;
    private final CustomerRepository customerRepository;

    @GetMapping(value="/{customerId}")
    public ResponseEntity<CustomerRewards> getRewardsByCustomerId(@PathVariable("customerId") long customerId)
        throws ResourceNotFoundException {
        if(customerRepository.findById(customerId).isEmpty()){
            throw new ResourceNotFoundException("Customer is not Found");
        }
        CustomerRewards cr = customerRewardsService.getRewardsByCustomerWithTimePeriod(customerId);
        return new ResponseEntity<>(cr, HttpStatus.OK);
    }
}
