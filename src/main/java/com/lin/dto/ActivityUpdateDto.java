package com.lin.dto;

import lombok.Data;

@Data
public class ActivityUpdateDto {
	private String id;
	private String title;
	private String content;
	private Integer discountType; // 0=no discount, 1=percent,2=cash
	private Float percentOff;
	private Float cashOff;
}
