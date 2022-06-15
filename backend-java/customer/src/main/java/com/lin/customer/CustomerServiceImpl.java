package com.lin.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lin.customer.dto.CustomerAddDto;
import com.lin.customer.dto.CustomerDeleteDto;
import com.lin.customer.dto.CustomerQueryDto;
import com.lin.customer.dto.CustomerUpdateDto;
import com.lin.entities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void addCustomer(CustomerAddDto dto) {
	}

	@Override
	public void updateCustomer(CustomerUpdateDto dto) {
	}

	@Override
	public void deleteCustomer(CustomerDeleteDto dto) {
	}

	@Override
	public Customer findCustomerById(CustomerQueryDto dto) {
		return null;
	}

	@Override
	public Page<Customer> findCustomers(CustomerQueryDto dto) {
		PageRequest pageRequest = PageRequest.of(dto.getPageNumber(), dto.getPageSize());
		return null;
	}

}
