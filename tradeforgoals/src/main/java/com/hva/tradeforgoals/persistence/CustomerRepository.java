package com.hva.tradeforgoals.persistence;

import com.hva.tradeforgoals.domain.Customer;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findById(String id);

    void deleteById(String id);

}
