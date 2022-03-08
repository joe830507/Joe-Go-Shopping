package com.lin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lin.dto.EmployeeAddDto;
import com.lin.dto.EmployeeUpdateDto;
import com.lin.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public void addEmployee(@RequestBody EmployeeAddDto dto) {
		employeeService.addEmployee(dto);
	}

	@PutMapping
	public void updateEmployee(@RequestBody EmployeeUpdateDto dto) {
		employeeService.updateEmployee(dto);
	}
}
