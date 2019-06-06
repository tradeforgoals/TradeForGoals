package com.hva.tradeforgoals.persistence;

import com.hva.tradeforgoals.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> findById(String id);

    void deleteById(String fakeID);
}
