package com.lin.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class Customer {
	private String id;
	private String firstName;
	private String lastName;
	// unique, cannot be updated
	private String account;
	@JsonIgnore
	private String password;
	private Date createTime;
	private Date updateTime;
}
