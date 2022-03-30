package com.lin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.lin.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public ApiResult queryEmployees(EmployeeQueryDto query) {
		if (StringUtils.hasText(query.getId()))
			return ApiResult.ok(employeeService.findEmployeeById(query));
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
