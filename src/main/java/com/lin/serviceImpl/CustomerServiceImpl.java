package com.lin.serviceImpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lin.dto.CustomerAddDto;
import com.lin.dto.CustomerDeleteDto;
import com.lin.dto.CustomerQueryDto;
import com.lin.dto.CustomerUpdateDto;
import com.lin.entity.Customer;
import com.lin.repository.CustomerRepository;
import com.lin.service.CustomerService;
import com.lin.util.BeanUtil;
import com.lin.util.UUIDUtil;

@Service
public class CustomerServiceImpl implements CustomerService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void addCustomer(CustomerAddDto dto) {
		Customer customer = modelMapper.map(dto, Customer.class);
		customer.setId(UUIDUtil.getIdWithoutDashes());
		customer.setCreateTime(new Date());
		customerRepository.insert(customer);
	}

	@Override
	public void updateCustomer(CustomerUpdateDto dto) {
		Customer updatedOne = modelMapper.map(dto, Customer.class);
		Customer origin = customerRepository.findById(dto.getId()).get();
		BeanUtil.copyPropertiesWithoutNull(updatedOne, origin);
		origin.setUpdateTime(new Date());
		customerRepository.save(origin);
	}

	@Override
	public void deleteCustomer(CustomerDeleteDto dto) {
		logger.info("deleted id: {}", dto.getId());
		customerRepository.deleteById(dto.getId());
	}

	@Override
	public Customer findCustomerById(CustomerQueryDto dto) {
		return customerRepository.findById(dto.getId()).get();
	}

	@Override
	public Page<Customer> findCustomers(CustomerQueryDto dto) {
		PageRequest pageRequest = PageRequest.of(dto.getPageNumber(), dto.getPageSize());
		return customerRepository.findAll(pageRequest);
	}

}
