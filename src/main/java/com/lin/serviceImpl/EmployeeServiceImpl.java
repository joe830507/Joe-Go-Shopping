package com.lin.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lin.dto.EmployeeAddDto;
import com.lin.dto.EmployeeUpdateDto;
import com.lin.entity.Employee;
import com.lin.repository.EmployeesRepository;
import com.lin.service.EmployeeService;
import com.lin.util.BeanUtil;
import com.lin.util.UUIDUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private EmployeesRepository employeeRepository;

	@Override
	public void addEmployee(EmployeeAddDto dto) {
		Employee employee = modelMapper.map(dto, Employee.class);
		employee.setId(UUIDUtil.getIdWithoutDashes());
		employeeRepository.insert(employee);
	}

	@Override
	public void updateEmployee(EmployeeUpdateDto dto) {
		Employee updateOne = modelMapper.map(dto, Employee.class);
		Employee origin = employeeRepository.findById(dto.getId()).get();
		BeanUtil.copyPropertiesWithoutNull(updateOne, origin);
		employeeRepository.save(origin);
	}

	@Override
	public Employee findEmployeeById(String id) {
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public List<Employee> findEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void deleteEmployee(String id) {
		logger.info("deleted id: {}", id);
		employeeRepository.deleteById(id);
	}

}
