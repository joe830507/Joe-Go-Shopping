package com.lin.dto;

import lombok.Data;

@Data
public class EmployeeQueryDto {

	private String id;
	private Integer pageNumber = 0;
	private Integer pageSize = 5;
}
