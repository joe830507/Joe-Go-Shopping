package com.lin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class Employee {
	private String id;
	private String firstName;
	private String lastName;
	// unique, cannot be updated
	private String account;
	@JsonIgnore
	private String password;
}
