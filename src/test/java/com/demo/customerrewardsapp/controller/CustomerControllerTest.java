package com.demo.customerrewardsapp.controller;


import com.demo.customerrewardsapp.entity.Customer;
import com.demo.customerrewardsapp.exception.ResourceNotFoundException;
import com.demo.customerrewardsapp.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private CustomerService customerService;

    @BeforeEach
    public void setUp() throws ResourceNotFoundException {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setCustomerName("customer1");
        customer.setEmail("cust@gmail.com");

        Mockito.when(customerService.getCustomerById(1L))
                .thenReturn(customer);
        doThrow(ResourceNotFoundException.class)
                .when(customerService).getCustomerById(2L);

        Mockito.when(customerService.createCustomer(any()))
                .thenReturn(customer);
    }

    @Test
    public void getCustomer_StatusNotFound()
            throws Exception {

        mockMvc.perform(get("/customer/2"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getCustomer_Success()
            throws Exception {

        mockMvc.perform(get("/customer/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerId").value(1L))
                .andExpect(jsonPath("$.customerName").value("customer1"))
                .andExpect(jsonPath("$.email").value("cust@gmail.com"));
    }
}
