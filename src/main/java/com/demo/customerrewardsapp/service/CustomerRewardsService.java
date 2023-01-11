package com.demo.customerrewardsapp.service;

import com.demo.customerrewardsapp.model.CustomerRewards;
/**
 * 
 * CustomerRewards Service to get rewards based on timeperiod and customerid
 * @author Ragu
 *
 */
public interface CustomerRewardsService {
    public CustomerRewards getRewardsByCustomerWithTimePeriod(long customerId);
}
