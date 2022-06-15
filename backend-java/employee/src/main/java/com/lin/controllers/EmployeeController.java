package com.lin.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lin.dto.ApiResult;
import com.lin.dto.EmployeeAddDto;
import com.lin.dto.EmployeeDeleteDto;
import com.lin.dto.EmployeeQueryDto;
import com.lin.dto.EmployeeUpdateDto;
import com.lin.entities.Employee;
import com.lin.services.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/{id}")
	public ApiResult getEmployeeById(@PathVariable String id) {
		Optional<Employee> employee = employeeService.findEmployeeById(id);
		if (employee.isPresent())
			return ApiResult.ok(employee.get());
		else
			return ApiResult.fail();
	}

	@GetMapping
	public ApiResult getEmployees(EmployeeQueryDto query) {
		return ApiResult.ok(employeeService.findEmployees(query));
	}

	@PostMapping
	public ApiResult addEmployee(@RequestBody EmployeeAddDto dto) {
		employeeService.addEmployee(dto);
		return ApiResult.ok();
	}

	@PutMapping
	public ApiResult updateEmployee(@RequestBody EmployeeUpdateDto dto) {
		employeeService.updateEmployee(dto);
		return ApiResult.ok();
	}

	@DeleteMapping
	public ApiResult deleteEmployee(EmployeeDeleteDto dto) {
		employeeService.deleteEmployee(dto.getId());
		return ApiResult.ok();
	}
}
