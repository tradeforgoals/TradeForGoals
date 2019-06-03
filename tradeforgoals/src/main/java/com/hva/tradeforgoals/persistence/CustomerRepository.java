package com.hva.tradeforgoals.persistence;

import com.hva.tradeforgoals.domain.Customer;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	void deleteById(String id);

	Optional<Customer> findById(String id);
}
