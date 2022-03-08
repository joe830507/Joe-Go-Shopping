package com.lin.entity;

import lombok.Data;

@Data
public class Customer {
	private String id;
	private String firstName;
	private String lastName;
	// unique, cannot be updated
	private String account;
	private String password;
}
