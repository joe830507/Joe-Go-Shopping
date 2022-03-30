package com.lin.dto;

import lombok.Data;

@Data
public class PermissionAddDto {
	private String name;
	private String parentId;
	private Integer level;
}
