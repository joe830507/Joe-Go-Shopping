package com.lin.entity;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Role {
	private String id;
	private String name;
	private List<String> permissionList;
	private Date createTime;
	private Date updateTime;
}
