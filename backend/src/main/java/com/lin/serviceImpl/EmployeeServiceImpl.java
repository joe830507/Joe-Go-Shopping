package com.lin.serviceImpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lin.dto.EmployeeAddDto;
import com.lin.dto.EmployeeQueryDto;
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
		employee.setCreateTime(new Date());
		employeeRepository.insert(employee);
	}

	@Override
	public void updateEmployee(EmployeeUpdateDto dto) {
		Employee updateOne = modelMapper.map(dto, Employee.class);
		Employee origin = employeeRepository.findById(dto.getId()).get();
		BeanUtil.copyPropertiesWithoutNull(updateOne, origin);
		origin.setUpdateTime(new Date());
		employeeRepository.save(origin);
	}

	@Override
	public Employee findEmployeeById(EmployeeQueryDto dto) {
		return employeeRepository.findById(dto.getId()).get();
	}

	@Override
	public Page<Employee> findEmployees(EmployeeQueryDto dto) {
		PageRequest pageRequest = PageRequest.of(dto.getPageNumber(), dto.getPageSize());
		return employeeRepository.findAll(pageRequest);
	}

	@Override
	public void deleteEmployee(String id) {
		logger.info("deleted id: {}", id);
		employeeRepository.deleteById(id);
	}

}
