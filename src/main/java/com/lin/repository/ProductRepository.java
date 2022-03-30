package com.lin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lin.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
