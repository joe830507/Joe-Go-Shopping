package com.lin.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lin.dto.EmployeeAddDto;
import com.lin.dto.EmployeeQueryDto;
import com.lin.dto.EmployeeUpdateDto;
import com.lin.entities.Employee;
import com.lin.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Optional<Employee> findEmployeeById(String id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		return optional;
	}

	@Override
	public Page<Employee> findEmployees(EmployeeQueryDto dto) {
		PageRequest pageRequest = PageRequest.of(dto.getPageNumber(), dto.getPageSize());
		return employeeRepository.findAll(pageRequest);
	}

	@Override
	public void addEmployee(EmployeeAddDto dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEmployee(EmployeeUpdateDto dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEmployee(String id) {
		// TODO Auto-generated method stub

	}

}
