package com.demo.customerrewardsapp.model;


import lombok.Data;
/**
 * 
 * RewardPoints POJO
 * @author Ragu
 *
 */
@Data
public class RewardPoints {

    private int threeMonthRewards;
    private int twoMonthRewards;
    private int lastMonthRewards;
    private int totalRewards;
}
