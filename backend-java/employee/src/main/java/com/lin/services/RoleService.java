package com.lin.services;

import org.springframework.data.domain.Page;

import com.lin.dto.RoleAddDto;
import com.lin.dto.RoleDeleteDto;
import com.lin.dto.RoleQueryDto;
import com.lin.dto.RoleUpdateDto;
import com.lin.entities.Role;

public interface RoleService {
	void addRole(RoleAddDto dto);

	void updateRole(RoleUpdateDto dto);

	void deleteRole(RoleDeleteDto dto);

	Role findRole(RoleQueryDto dto);

	Page<Role> findRoles(RoleQueryDto dto);
}
