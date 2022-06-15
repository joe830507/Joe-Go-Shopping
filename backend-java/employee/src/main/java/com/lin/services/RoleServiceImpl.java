package com.lin.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.lin.dto.RoleAddDto;
import com.lin.dto.RoleDeleteDto;
import com.lin.dto.RoleQueryDto;
import com.lin.dto.RoleUpdateDto;
import com.lin.entities.Role;

@Service
public class RoleServiceImpl implements RoleService {

	@Override
	public void addRole(RoleAddDto dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateRole(RoleUpdateDto dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRole(RoleDeleteDto dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public Role findRole(RoleQueryDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Role> findRoles(RoleQueryDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
