package com.lin.serviceImpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lin.dto.OrderAddDto;
import com.lin.dto.OrderDeleteDto;
import com.lin.dto.OrderQueryDto;
import com.lin.dto.OrderUpdateDto;
import com.lin.entity.Order;
import com.lin.mongo.repository.OrderRepository;
import com.lin.service.OrderService;
import com.lin.util.UUIDUtil;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void addOrder(OrderAddDto addDto) {
		Order order = modelMapper.map(addDto, Order.class);
		order.setId(UUIDUtil.getIdWithoutDashes());
		order.setCreateTime(new Date());
		orderRepository.insert(order);
	}

	@Override
	public void updateOrder(OrderUpdateDto updateDto) {
		Order order = modelMapper.map(updateDto, Order.class);
		order.setId(UUIDUtil.getIdWithoutDashes());
		order.setUpdateTime(new Date());
		orderRepository.save(order);
	}

	@Override
	public void deleteOrder(OrderDeleteDto deleteDto) {
		orderRepository.deleteById(deleteDto.getId());
	}

	@Override
	public Order findOrder(OrderQueryDto queryDto) {
		Order order = modelMapper.map(queryDto, Order.class);
		Example<Order> example = Example.of(order);
		return orderRepository.findOne(example).get();
	}

	@Override
	public Page<Order> findOrders(OrderQueryDto queryDto) {
		PageRequest request = PageRequest.of(queryDto.getPageNumber(), queryDto.getPageSize());
		return orderRepository.findAll(request);
	}

}
