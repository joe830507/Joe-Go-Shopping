package com.lin.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lin.entity.Activity;

public interface ActivityMongoRepository extends MongoRepository<Activity, String> {

}
