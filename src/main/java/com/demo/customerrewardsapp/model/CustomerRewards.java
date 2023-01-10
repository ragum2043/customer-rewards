package com.demo.customerrewardsapp.model;


import lombok.Data;

@Data
public class CustomerRewards {

    private long customerId;
    private RewardPoints rewardPoints;
}
