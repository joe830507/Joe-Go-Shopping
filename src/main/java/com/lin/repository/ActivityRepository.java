package com.lin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lin.entity.Activity;

public interface ActivityRepository extends MongoRepository<Activity, String> {

}
