package com.lin.services;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.lin.dto.EmployeeAddDto;
import com.lin.dto.EmployeeQueryDto;
import com.lin.dto.EmployeeUpdateDto;
import com.lin.entities.Employee;

public interface EmployeeService {
	Optional<Employee> findEmployeeById(String id);

	Page<Employee> findEmployees(EmployeeQueryDto dto);

	void addEmployee(EmployeeAddDto dto);

	void updateEmployee(EmployeeUpdateDto dto);

	void deleteEmployee(String id);
}
