package com.lin.dto;

import lombok.Data;

@Data
public class CustomerUpdateDto {
	private String id;
	private String firstName;
	private String lastName;
	private String password;
}
