package com.lin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lin.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
