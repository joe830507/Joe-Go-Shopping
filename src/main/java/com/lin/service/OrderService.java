package com.lin.service;

import org.springframework.data.domain.Page;

import com.lin.dto.OrderAddDto;
import com.lin.dto.OrderDeleteDto;
import com.lin.dto.OrderQueryDto;
import com.lin.dto.OrderUpdateDto;
import com.lin.entity.Order;

public interface OrderService {

	void addOrder(OrderAddDto addDto);

	void updateOrder(OrderUpdateDto updateDto);

	void deleteOrder(OrderDeleteDto deleteDto);

	Order findOrder(OrderQueryDto queryDto);

	Page<Order> findOrders(OrderQueryDto queryDto);
}
