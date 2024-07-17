package com.akbar.redispatterns.cacheaside.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.akbar.redispatterns.cacheaside.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    @Query("{ 'productDisplayName' : { $regex: ?0, $options: 'i' } }")
    List<Product> findProductByProductDisplayNameContainingIgnoreCase(String productDisplayName);
}
