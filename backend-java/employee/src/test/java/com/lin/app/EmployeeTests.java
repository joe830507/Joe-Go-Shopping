package com.lin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;

import com.lin.controller.EmployeeController;
import com.lin.dto.ApiResult;
import com.lin.dto.EmployeeAddDto;
import com.lin.dto.EmployeeDeleteDto;
import com.lin.dto.EmployeeQueryDto;
import com.lin.dto.EmployeeUpdateDto;
import com.lin.entity.Employee;
import com.lin.mongo.repository.EmployeesRepository;

@SpringBootTest
class EmployeeTests {

	@Autowired
	private EmployeeController employeeController;

	@Autowired
	private EmployeesRepository employeesRepository;

	@Test
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
		employeesRepository.deleteAll();
	}

	@Test
	void updateEmployee() {
		EmployeeAddDto updateDto = new EmployeeAddDto();
		updateDto.setAccount("test");
		updateDto.setPassword("dto");
		updateDto.setFirstName("George");
		updateDto.setLastName("Bell");
		employeeController.addEmployee(updateDto);
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
	void queryEmployees() {
		addEmployees();
		EmployeeQueryDto queryDto = new EmployeeQueryDto();
		ApiResult result = employeeController.queryEmployees(queryDto);
		@SuppressWarnings("unchecked")
		Page<Employee> employeePage = (Page<Employee>) result.getResponseBody();
		List<Employee> employees = employeePage.getContent();
		assertEquals(2, employees.size());
		employeesRepository.deleteAll();
	}

	private void addEmployees() {
		EmployeeAddDto dto = new EmployeeAddDto();
		dto.setAccount("test");
		dto.setPassword("dto");
		dto.setFirstName("George");
		dto.setLastName("Bell");
		employeeController.addEmployee(dto);
		dto.setAccount("test2");
		dto.setPassword("dto2");
		dto.setFirstName("George2");
		dto.setLastName("Bell2");
		employeeController.addEmployee(dto);
	}

}
