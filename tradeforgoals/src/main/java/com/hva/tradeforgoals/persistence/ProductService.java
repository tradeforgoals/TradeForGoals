package com.hva.tradeforgoals.persistence;

import com.hva.tradeforgoals.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> findAll(){
        Iterable<Product> result = productRepository.findAll();

        return result;
    }

    public Product findById(Long id){
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

}
