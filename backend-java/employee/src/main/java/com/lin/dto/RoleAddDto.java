package com.lin.dto;

import java.util.List;

import lombok.Data;

@Data
public class RoleAddDto {
	private String name;
	private List<String> permissionList;
}
