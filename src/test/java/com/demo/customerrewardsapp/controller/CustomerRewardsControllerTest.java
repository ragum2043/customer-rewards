package com.demo.customerrewardsapp.controller;


import com.demo.customerrewardsapp.entity.Customer;
import com.demo.customerrewardsapp.exception.ResourceNotFoundException;
import com.demo.customerrewardsapp.model.CustomerRewards;
import com.demo.customerrewardsapp.model.RewardPoints;
import com.demo.customerrewardsapp.repository.CustomerRepository;
import com.demo.customerrewardsapp.service.CustomerRewardsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRewardsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRewardsService customerRewardsService;

    @MockBean
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() throws ResourceNotFoundException {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setCustomerName("customer1");
        customer.setEmail("cust@gmail.com");

        CustomerRewards cr = new CustomerRewards();
        cr.setCustomerId(1L);
        RewardPoints rp = new RewardPoints();
        rp.setThreeMonthRewards(10);
        rp.setTwoMonthRewards(20);
        rp.setLastMonthRewards(30);
        rp.setTotalRewards(60);

        cr.setRewardPoints(rp);


        Mockito.when(customerRewardsService.getRewardsByCustomerWithTimePeriod(1L))
                .thenReturn(cr);

        Mockito.when(customerRepository.findById(1L))
                .thenReturn(Optional.of(customer));

        Mockito.when(customerRepository.findById(2L))
                .thenReturn(Optional.empty());

    }

    @Test
    public void getCustomer_Success()
            throws Exception {

       mockMvc.perform(get("/rewards/customer/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
               .andDo(print())
               .andExpect(jsonPath("$.rewardPoints.threeMonthRewards").value(10))
               .andExpect(jsonPath("$.rewardPoints.twoMonthRewards").value(20))
               .andExpect(jsonPath("$.rewardPoints.lastMonthRewards").value(30))
               .andExpect(jsonPath("$.rewardPoints.totalRewards").value(60));
    }

    @Test
    public void getCustomer_Fail()
            throws Exception {

        mockMvc.perform(get("/rewards/customer/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
