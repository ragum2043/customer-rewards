package com.demo.customerrewardsapp.model;


import lombok.Data;
/**
 * 
 * CustomerRewards POJO
 * @author Ragu
 *
 */
@Data
public class CustomerRewards {

    private long customerId;
    private RewardPoints rewardPoints;
}
