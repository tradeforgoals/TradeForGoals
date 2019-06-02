package com.hva.tradeforgoals.persistence;

import com.hva.tradeforgoals.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
