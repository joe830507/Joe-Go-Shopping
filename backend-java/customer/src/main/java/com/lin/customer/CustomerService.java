package com.lin.customer;

import org.springframework.data.domain.Page;

import com.lin.customer.dto.CustomerAddDto;
import com.lin.customer.dto.CustomerDeleteDto;
import com.lin.customer.dto.CustomerQueryDto;
import com.lin.customer.dto.CustomerUpdateDto;
import com.lin.entities.Customer;

public interface CustomerService {

	void addCustomer(CustomerAddDto dto);

	void updateCustomer(CustomerUpdateDto dto);

	void deleteCustomer(CustomerDeleteDto dto);

	Customer findCustomerById(CustomerQueryDto dto);

	Page<Customer> findCustomers(CustomerQueryDto dto);

}
