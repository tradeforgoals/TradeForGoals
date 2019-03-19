package com.hva.tradeforgoals.persistence;

import com.hva.tradeforgoals.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
