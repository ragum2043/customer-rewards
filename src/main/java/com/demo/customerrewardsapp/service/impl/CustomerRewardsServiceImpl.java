package com.demo.customerrewardsapp.service.impl;

import com.demo.customerrewardsapp.entity.Transactions;
import com.demo.customerrewardsapp.model.CustomerRewards;
import com.demo.customerrewardsapp.model.RewardPoints;
import com.demo.customerrewardsapp.repository.TransactionsRepository;
import com.demo.customerrewardsapp.service.CustomerRewardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
/**
 * 
 * Customer rewards business logic implementation
 * @author Ragu
 *
 */
@Service
@RequiredArgsConstructor
public class CustomerRewardsServiceImpl implements CustomerRewardsService {
    private final TransactionsRepository transactionsRepository;

    public CustomerRewards getRewardsByCustomerWithTimePeriod(long customerId) {
        Iterable<Transactions> allTrans = transactionsRepository.findAll();
        List<Transactions> threeMonthBackTransactions = transactionsRepository.
                findAllByCustomerIdAndDateBetween(customerId, Timestamp.valueOf(LocalDateTime.now().minusDays(90)),
                        Timestamp.valueOf(LocalDateTime.now().minusDays(60)));
        List<Transactions> twoMonthBackTransactions = transactionsRepository.
                findAllByCustomerIdAndDateBetween(customerId, Timestamp.valueOf(LocalDateTime.now().minusDays(60)),
                        Timestamp.valueOf(LocalDateTime.now().minusDays(30)));
        List<Transactions> lastMonthTransactions = transactionsRepository.
                findAllByCustomerIdAndDateBetween(customerId, Timestamp.valueOf(LocalDateTime.now().minusDays(30)),
                        Timestamp.from(Instant.now()));

        int lastMonthRewards = getCustomerRewards(lastMonthTransactions);
        int twoMonthBackRewards = getCustomerRewards(twoMonthBackTransactions);
        int threeMonthBackRewards = getCustomerRewards(threeMonthBackTransactions);

        RewardPoints rp = new RewardPoints();
        rp.setTotalRewards(lastMonthRewards+twoMonthBackRewards+threeMonthBackRewards);
        rp.setLastMonthRewards(lastMonthRewards);
        rp.setTwoMonthRewards(twoMonthBackRewards);
        rp.setThreeMonthRewards(threeMonthBackRewards);
        CustomerRewards cr = new CustomerRewards();
        cr.setCustomerId(customerId);
        cr.setRewardPoints(rp);
        return cr;
    }


    private int getCustomerRewards(List<Transactions> transactions){
        return transactions.stream().map(t -> {
            if(t.getAmount() > 50 && t.getAmount() <= 100){
                return t.getAmount()-50;
            } else if(t.getAmount() > 100){
                 return ((t.getAmount() - 100)*2) + 50;
            } else {  return Integer.valueOf(0); }
        }).collect(Collectors.summingInt(x -> x.intValue()));
    }
}
