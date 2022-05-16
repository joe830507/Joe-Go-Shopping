package com.lin.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lin.entity.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
