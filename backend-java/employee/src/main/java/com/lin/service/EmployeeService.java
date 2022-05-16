package com.lin.service;

import org.springframework.data.domain.Page;

import com.lin.dto.EmployeeAddDto;
import com.lin.dto.EmployeeQueryDto;
import com.lin.dto.EmployeeUpdateDto;
import com.lin.entity.Employee;

public interface EmployeeService {
	Employee findEmployeeById(EmployeeQueryDto dto);

	Page<Employee> findEmployees(EmployeeQueryDto dto);

	void addEmployee(EmployeeAddDto dto);

	void updateEmployee(EmployeeUpdateDto dto);

	void deleteEmployee(String id);
}
