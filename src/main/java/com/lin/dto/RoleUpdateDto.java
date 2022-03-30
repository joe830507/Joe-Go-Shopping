package com.lin.dto;

import java.util.List;

import lombok.Data;

@Data
public class RoleUpdateDto {
	private String id;
	private List<String> permissionList;
}
