package com.lin.app;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.util.CollectionUtils;

import com.lin.controller.EmployeeController;
import com.lin.dto.ApiResult;
import com.lin.dto.EmployeeAddDto;
import com.lin.dto.EmployeeDeleteDto;
import com.lin.dto.EmployeeQueryDto;
import com.lin.dto.EmployeeUpdateDto;
import com.lin.entity.Employee;
import com.lin.repository.EmployeesRepository;

@SpringBootTest
class EmployeeTests {

	@Autowired
	private EmployeeController employeeController;

	@Autowired
	private EmployeesRepository employeesRepository;

	@Test
	@Order(value = 1)
	void addEmployee() {
		EmployeeAddDto dto = new EmployeeAddDto();
		dto.setAccount("test");
		dto.setPassword("dto");
		dto.setFirstName("George");
		dto.setLastName("Bell");
		employeeController.addEmployee(dto);
		Employee employee = new Employee();
		employee.setAccount("test");
		employee.setFirstName("George");
		employee.setLastName("Bell");
		Example<Employee> example = Example.of(employee);
		Boolean isPresent = employeesRepository.findOne(example).isPresent();
		assertTrue(isPresent);
	}

	@Test
	@Order(value = 2)
	void updateEmployee() {
		Employee employee = employeesRepository.findAll().get(0);
		EmployeeUpdateDto dto = new EmployeeUpdateDto();
		dto.setId(employee.getId());
		dto.setPassword("sadjsaldkjwkld");
		employeeController.updateEmployee(dto);
		Boolean isPresent = employeesRepository.findById(dto.getId()).isPresent();
		assertTrue(isPresent);
		employeesRepository.deleteAll();
	}

	@Test
	@Order(value = 3)
	void deleteEmployee() {
		EmployeeAddDto dto = new EmployeeAddDto();
		dto.setAccount("test");
		dto.setPassword("dto");
		dto.setFirstName("George");
		dto.setLastName("Bell");
		employeeController.addEmployee(dto);
		Employee emp = employeesRepository.findAll().get(0);
		EmployeeDeleteDto deleteDto = new EmployeeDeleteDto();
		deleteDto.setId(emp.getId());
		employeeController.deleteEmployee(deleteDto);
		Boolean isPresent = employeesRepository.findById(emp.getId()).isPresent();
		assertFalse(isPresent);
	}

	@Test
	@Order(value = 4)
	void queryEmployees() {
		EmployeeAddDto dto = new EmployeeAddDto();
		dto.setAccount("test");
		dto.setPassword("dto");
		dto.setFirstName("George");
		dto.setLastName("Bell");
		employeeController.addEmployee(dto);
		EmployeeQueryDto queryDto = new EmployeeQueryDto();
		ApiResult result = employeeController.queryEmployees(queryDto);
		@SuppressWarnings("unchecked")
		List<Employee> employees = (List<Employee>) result.getResponseBody();
		if (!CollectionUtils.isEmpty(employees)) {
			String id = employees.get(0).getId();
			queryDto.setId(id);
			result = employeeController.queryEmployees(queryDto);
			Employee singleEmployee = (Employee) result.getResponseBody();
			assertNotNull(singleEmployee);
			employeesRepository.deleteById(id);
		}
	}

}
