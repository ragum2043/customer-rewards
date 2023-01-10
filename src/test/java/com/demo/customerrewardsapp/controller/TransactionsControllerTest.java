package com.demo.customerrewardsapp.controller;


import com.demo.customerrewardsapp.entity.Customer;
import com.demo.customerrewardsapp.entity.Transactions;
import com.demo.customerrewardsapp.exception.ResourceNotFoundException;
import com.demo.customerrewardsapp.service.CustomerService;
import com.demo.customerrewardsapp.service.TransactionsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionsControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private TransactionsService transactionsService;

    @MockBean
    private CustomerService customerService;

    @BeforeEach
    public void setUp() throws ResourceNotFoundException {
        Transactions transactions = new Transactions();
        transactions.setTransactionId(5L);
        transactions.setCustomerId(1L);
        transactions.setAmount(120);
        transactions.setDate(Timestamp.valueOf(LocalDateTime.now()));

        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setCustomerName("customer1");
        customer.setEmail("cust@gmail.com");

        Mockito.when(customerService.getCustomerById(1L))
                        .thenReturn(customer);
        Mockito.when(transactionsService.createTransaction(any()))
                .thenReturn(transactions);
    }

    @Test
    public void createTransactions() throws Exception {

        mockMvc.perform(post("/transaction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"transactionId\":123,\"customerId\":1,\"amount\":120,\"date\":\"2023-01-01\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.amount").value(120));
    }
}
