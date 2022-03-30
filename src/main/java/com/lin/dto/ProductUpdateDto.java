package com.lin.dto;

import lombok.Data;

@Data
public class ProductUpdateDto {
	private String id;
	private String name;
	private Float number;
	private Float importPirce;
	private Float salesPrice;
}
