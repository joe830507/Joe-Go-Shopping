package com.lin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lin.entity.Order;

public interface OrderRepository extends MongoRepository<Order, String> {

}
