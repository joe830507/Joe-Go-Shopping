package com.lin.dto;

import lombok.Data;

@Data
public class OrderQueryDto {
	private String id;
	private String buyer;
	private String operator;
	private Integer deliverStatus;
	private String activityId;
	private Integer pageNumber = 0;
	private Integer pageSize = 5;
}
