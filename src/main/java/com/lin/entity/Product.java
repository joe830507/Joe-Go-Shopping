package com.lin.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Product {
	private String id;
	private String name;
	private Float number;
	private Float importPirce;
	private Float salesPrice;
	private Date createTime;
	private Date updateTime;
}
