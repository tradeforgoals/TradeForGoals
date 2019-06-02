package com.hva.tradeforgoals.persistence;

import com.hva.tradeforgoals.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<Customer> findAll() {
        Iterable<Customer> result = customerRepository.findAll();
        return result;
    }

    public Customer findById(long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isPresent()) {
            return customer.get();
        }else{
            return null;
        }
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteById(long id) {
        customerRepository.deleteById(id);
    }
}

