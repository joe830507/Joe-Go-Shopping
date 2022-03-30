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
import com.lin.dto.CustomerAddDto;
import com.lin.dto.CustomerDeleteDto;
import com.lin.dto.CustomerQueryDto;
import com.lin.dto.CustomerUpdateDto;
import com.lin.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	public ApiResult addCustomer(@RequestBody CustomerAddDto dto) {
		customerService.addCustomer(dto);
		return ApiResult.ok();
	}

	@PutMapping
	public ApiResult updateCustomer(@RequestBody CustomerUpdateDto dto) {
		customerService.updateCustomer(dto);
		return ApiResult.ok();
	}

	@DeleteMapping
	public ApiResult deleteCustomer(@RequestBody CustomerDeleteDto dto) {
		customerService.deleteCustomer(dto);
		return ApiResult.ok();
	}

	@GetMapping
	public ApiResult queryCustomers(CustomerQueryDto dto) {
		if (StringUtils.hasText(dto.getId())) {
			return ApiResult.ok(customerService.findCustomerById(dto));
		}
		return ApiResult.ok(customerService.findCustomers(dto));
	}

}
