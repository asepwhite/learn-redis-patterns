package com.akbar.redispatterns.cacheaside.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akbar.redispatterns.cacheaside.entity.Product;
import com.akbar.redispatterns.cacheaside.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> searchProductsByDisplayName(String displayName) {
        return productRepository.findProductByProductDisplayNameContainingIgnoreCase(displayName);
    }
}
