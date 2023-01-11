package com.demo.customerrewardsapp.repository;

import com.demo.customerrewardsapp.entity.Transactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
/**
 * 
 * TransactionsRepository to query Transaction entity
 * @author Ragu
 *
 */
@Repository
public interface TransactionsRepository extends CrudRepository<Transactions, Long> {
    public List<Transactions> findAllByCustomerIdAndDateBetween(long customerId, Timestamp from, Timestamp to);
}
