package com.lin.services;

import java.util.List;

import com.lin.dto.PermissionAddDto;
import com.lin.dto.PermissionDeleteDto;
import com.lin.dto.PermissionQueryDto;
import com.lin.dto.PermissionUpdateDto;
import com.lin.entities.Permission;

public interface PermissionService {
	void addPermission(PermissionAddDto dto);

	void updatePermission(PermissionUpdateDto dto);

	void deletePermission(PermissionDeleteDto dto);

	Permission findPermission(PermissionQueryDto dto);

	List<Permission> findPermissions(PermissionQueryDto dto);
}
