package com.lin.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Permission {
	private String id;
	private String name;
	private String parentId;
	private Integer level;
	private Date createTime;
	private Date updateTime;
}
