package com.lin.dto;

import lombok.Data;

@Data
public class DtoBase {
	protected Integer pageNumber = 0;
	protected Integer pageSize = 5;
}
