package com.lin.service;

import java.util.List;

import com.lin.dto.EmployeeAddDto;
import com.lin.dto.EmployeeUpdateDto;
import com.lin.entity.Employee;

public interface EmployeeService {
	Employee findEmployeeById(String id);

	List<Employee> findEmployees();

	void addEmployee(EmployeeAddDto dto);

	void updateEmployee(EmployeeUpdateDto dto);

	void deleteEmployee(String id);
}
