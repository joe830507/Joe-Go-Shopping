package com.lin.dto;

import java.util.List;

import com.lin.entity.Product;

import lombok.Data;

@Data
public class OrderAddDto {
	private String buyer;
	private String operator;
	private List<Product> productList;
	private Integer deliverStatus;
	private String activityId;
}
