package com.lin.serviceImpl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lin.dto.PermissionAddDto;
import com.lin.dto.PermissionDeleteDto;
import com.lin.dto.PermissionQueryDto;
import com.lin.dto.PermissionUpdateDto;
import com.lin.entity.Permission;
import com.lin.repository.PermissionRepository;
import com.lin.service.PermissionService;
import com.lin.util.BeanUtil;
import com.lin.util.UUIDUtil;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionRepository permissionRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void addPermission(PermissionAddDto dto) {
		Permission permission = modelMapper.map(dto, Permission.class);
		permission.setId(UUIDUtil.getIdWithoutDashes());
		permission.setCreateTime(new Date());
		permissionRepository.insert(permission);
	}

	@Override
	public void updatePermission(PermissionUpdateDto dto) {
		Permission updateOne = modelMapper.map(dto, Permission.class);
		Permission origin = permissionRepository.findById(dto.getId()).get();
		BeanUtil.copyPropertiesWithoutNull(updateOne, origin);
		origin.setUpdateTime(new Date());
		permissionRepository.save(origin);
	}

	@Override
	public void deletePermission(PermissionDeleteDto dto) {
		permissionRepository.deleteById(dto.getId());
	}

	@Override
	public Permission findPermission(PermissionQueryDto dto) {
		return permissionRepository.findById(dto.getId()).get();
	}

	@Override
	public List<Permission> findPermissions(PermissionQueryDto dto) {
		return permissionRepository.findAll();
	}

}
