package com.lin.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lin.controller.EmployeeController;
import com.lin.dto.EmployeeAddDto;
import com.lin.dto.EmployeeUpdateDto;
import com.lin.entity.Employee;
import com.lin.repository.EmployeesRepository;

@SpringBootTest
class JoeJavaGroceryStoreApplicationTests {

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
	}

	@Test
	void updateEmployee() {
		Employee employee = employeesRepository.findAll().get(0);
		EmployeeUpdateDto dto = new EmployeeUpdateDto();
		dto.setId(employee.getId());
		dto.setPassword("sadjsaldkjwkld");
		employeeController.updateEmployee(dto);
		System.out.println(employeesRepository.findById(dto.getId()));
		employeesRepository.deleteById(dto.getId());
	}

}
