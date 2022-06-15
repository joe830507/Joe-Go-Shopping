package com.lin.customer.dto;

import lombok.Data;

@Data
public class CustomerQueryDto {

	private String id;
	private Integer pageNumber = 0;
	private Integer pageSize = 5;
}
