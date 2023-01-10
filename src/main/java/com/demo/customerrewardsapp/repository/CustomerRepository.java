package com.demo.customerrewardsapp.repository;

import com.demo.customerrewardsapp.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {}
