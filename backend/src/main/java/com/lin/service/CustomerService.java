package com.lin.service;

import org.springframework.data.domain.Page;

import com.lin.dto.CustomerAddDto;
import com.lin.dto.CustomerDeleteDto;
import com.lin.dto.CustomerQueryDto;
import com.lin.dto.CustomerUpdateDto;
import com.lin.entity.Customer;

public interface CustomerService {

	void addCustomer(CustomerAddDto dto);

	void updateCustomer(CustomerUpdateDto dto);

	void deleteCustomer(CustomerDeleteDto dto);

	Customer findCustomerById(CustomerQueryDto dto);

	Page<Customer> findCustomers(CustomerQueryDto dto);

}
