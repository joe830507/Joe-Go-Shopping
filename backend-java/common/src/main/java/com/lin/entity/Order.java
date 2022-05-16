package com.lin.entity;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Order {
	private String id;
	private String buyer;
	private String operator;
	private List<Product> productList;
	private Integer deliverStatus;
	private String activityId;
	private Date createTime;
	private Date updateTime;
}
