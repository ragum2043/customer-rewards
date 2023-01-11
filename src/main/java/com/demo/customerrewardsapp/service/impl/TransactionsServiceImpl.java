package com.demo.customerrewardsapp.service.impl;

import com.demo.customerrewardsapp.entity.Transactions;
import com.demo.customerrewardsapp.repository.TransactionsRepository;
import com.demo.customerrewardsapp.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
/**
 * 
 * Transactions business logc implementation
 * @author Ragu
 *
 */
@Service
@RequiredArgsConstructor
public class TransactionsServiceImpl implements TransactionsService {
    private final TransactionsRepository transactionsRepository;

    public Transactions createTransaction(Transactions transactions) {
        return transactionsRepository.save(transactions);
    }
}
