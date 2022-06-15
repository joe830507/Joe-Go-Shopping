package com.lin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lin.customer.CustomerController;
import com.lin.customer.dto.CustomerAddDto;
import com.lin.dto.ApiResult;
import com.lin.dto.ApiResult.ApiResultCode;

@SpringBootTest
public class CustomerTests {

	@Autowired
	private CustomerController customerController;

	@Test
	void addCustomer() {
		CustomerAddDto dto = new CustomerAddDto();
		dto.setAccount("testAccount");
		dto.setFirstName("Lebron");
		dto.setLastName("James");
		dto.setPassword("123456");
		ApiResult result = customerController.addCustomer(dto);
		assertEquals(ApiResultCode.SUCCESS, result.getCode());
	}

	@Test
	void updateCustomer() {
	}

	@Test
	void deleteCustomer() {
	}

	@Test
	void queryCustomers() {
	}

}
