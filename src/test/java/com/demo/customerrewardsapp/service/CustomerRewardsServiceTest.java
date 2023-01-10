package com.demo.customerrewardsapp.service;

import com.demo.customerrewardsapp.model.CustomerRewards;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRewardsServiceTest {

    @Autowired
    private CustomerRewardsService service;

    @Test
    @SqlGroup({
            @Sql(value = "classpath:data.sql", executionPhase = BEFORE_TEST_METHOD)
    })
    void getRewardsByCustomerWithTimePeriod() throws Exception {
        CustomerRewards cr = service.getRewardsByCustomerWithTimePeriod(1);
        assertThat(cr.getCustomerId()).isEqualTo(1);
        assertEquals(cr.getRewardPoints().getLastMonthRewards(), 2150);
        assertEquals(cr.getRewardPoints().getTwoMonthRewards(), 90);
        assertEquals(cr.getRewardPoints().getThreeMonthRewards(), 20);
        assertEquals(cr.getRewardPoints().getTotalRewards(), 2260);
    }
}
