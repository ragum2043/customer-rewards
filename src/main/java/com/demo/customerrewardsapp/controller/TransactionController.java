package com.demo.customerrewardsapp.controller;

import com.demo.customerrewardsapp.entity.Transactions;
import com.demo.customerrewardsapp.exception.ResourceNotFoundException;
import com.demo.customerrewardsapp.service.CustomerService;
import com.demo.customerrewardsapp.service.TransactionsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * Transaction Controller used to add transactions
 * @author Ragu
 *
 */
@RestController
@RequestMapping("/transaction")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TransactionController {

    private final TransactionsService transactionsService;
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Transactions> createTransaction(@RequestBody Transactions transactions) throws ResourceNotFoundException {
        customerService.getCustomerById(transactions.getCustomerId());
        return new ResponseEntity<>(transactionsService.createTransaction(transactions), HttpStatus.OK);
    }
}
