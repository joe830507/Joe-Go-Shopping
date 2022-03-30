package com.lin.dto;

import lombok.Data;

@Data
public class PermissionUpdateDto {
	private String id;
	private String name;
	private String parentId;
	private Integer level;
}
