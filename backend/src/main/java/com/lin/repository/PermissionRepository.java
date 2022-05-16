package com.lin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lin.entity.Permission;

public interface PermissionRepository extends MongoRepository<Permission, String> {

}
