package com.lin.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lin.entity.Employee;

public interface EmployeesRepository extends MongoRepository<Employee, String> {

}