package com.lin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lin.entity.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

}
