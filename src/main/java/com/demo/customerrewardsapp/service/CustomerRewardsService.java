package com.demo.customerrewardsapp.service;

import com.demo.customerrewardsapp.model.CustomerRewards;

public interface CustomerRewardsService {
    public CustomerRewards getRewardsByCustomerWithTimePeriod(long customerId);
}
