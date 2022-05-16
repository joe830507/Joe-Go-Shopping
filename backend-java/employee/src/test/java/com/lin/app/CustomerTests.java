package com.lin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;

import com.lin.controller.CustomerController;
import com.lin.dto.ApiResult;
import com.lin.dto.ApiResult.ApiResultCode;
import com.lin.dto.CustomerAddDto;
import com.lin.dto.CustomerDeleteDto;
import com.lin.dto.CustomerQueryDto;
import com.lin.dto.CustomerUpdateDto;
import com.lin.entity.Customer;
import com.lin.mongo.repository.CustomerRepository;

@SpringBootTest
public class CustomerTests {

	@Autowired
	private CustomerController customerController;

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void addCustomer() {
		CustomerAddDto dto = new CustomerAddDto();
		dto.setAccount("testAccount");
		dto.setFirstName("Lebron");
		dto.setLastName("James");
		dto.setPassword("123456");
		ApiResult result = customerController.addCustomer(dto);
		assertEquals(ApiResultCode.SUCCESS, result.getCode());
		customerRepository.deleteAll();
	}

	@Test
	void updateCustomer() {
		CustomerAddDto addDto = new CustomerAddDto();
		addDto.setAccount("testAccount");
		addDto.setFirstName("Lebron");
		addDto.setLastName("James");
		addDto.setPassword("123456");
		customerController.addCustomer(addDto);
		CustomerUpdateDto dto = new CustomerUpdateDto();
		Customer queryCustomer = new Customer();
		queryCustomer.setAccount("testAccount");
		Example<Customer> example = Example.of(queryCustomer);
		Customer customer = customerRepository.findOne(example).get();
		dto.setId(customer.getId());
		dto.setPassword("654321");
		customerController.updateCustomer(dto);
		String password = customerRepository.findById(customer.getId()).get().getPassword();
		assertEquals("654321", password);
		customerRepository.deleteById(customer.getId());
	}

	@Test
	void deleteCustomer() {
		CustomerAddDto addDto = new CustomerAddDto();
		addDto.setAccount("testAccount");
		addDto.setFirstName("Lebron");
		addDto.setLastName("James");
		addDto.setPassword("123456");
		customerController.addCustomer(addDto);
		Customer queryCustomer = new Customer();
		queryCustomer.setAccount("testAccount");
		Example<Customer> example = Example.of(queryCustomer);
		Customer customer = customerRepository.findOne(example).get();
		CustomerDeleteDto dto = new CustomerDeleteDto();
		dto.setId(customer.getId());
		customerController.deleteCustomer(dto);
		int size = customerRepository.findAll().size();
		assertEquals(0, size);
	}

	@Test
	void queryCustomers() {
		addCustomers();
		CustomerQueryDto dto = new CustomerQueryDto();
		ApiResult result = customerController.queryCustomers(dto);
		@SuppressWarnings("unchecked")
		Page<Customer> customerPage = (Page<Customer>) result.getResponseBody();
		List<Customer> customers = customerPage.getContent();
		assertEquals(2, customers.size());
		dto.setId(customers.get(0).getId());
		result = customerController.queryCustomers(dto);
		Customer c = (Customer) result.getResponseBody();
		assertNotNull(c);
		customerRepository.deleteAll();
	}

	void addCustomers() {
		CustomerAddDto addDto = new CustomerAddDto();
		addDto.setAccount("testAccount");
		addDto.setFirstName("Lebron");
		addDto.setLastName("James");
		addDto.setPassword("123456");
		customerController.addCustomer(addDto);
		addDto.setAccount("testAccount2");
		addDto.setFirstName("James");
		addDto.setLastName("Harden");
		addDto.setPassword("9999999");
		customerController.addCustomer(addDto);
	}

}
