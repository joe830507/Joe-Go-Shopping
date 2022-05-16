package com.lin.serviceImpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lin.dto.RoleAddDto;
import com.lin.dto.RoleDeleteDto;
import com.lin.dto.RoleQueryDto;
import com.lin.dto.RoleUpdateDto;
import com.lin.entity.Role;
import com.lin.mongo.repository.RoleRepository;
import com.lin.service.RoleService;
import com.lin.util.BeanUtil;
import com.lin.util.UUIDUtil;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void addRole(RoleAddDto dto) {
		Role role = modelMapper.map(dto, Role.class);
		role.setId(UUIDUtil.getIdWithoutDashes());
		role.setCreateTime(new Date());
		roleRepository.insert(role);
	}

	@Override
	public void updateRole(RoleUpdateDto dto) {
		Role origin = roleRepository.findById(dto.getId()).get();
		Role role = modelMapper.map(dto, Role.class);
		origin.setUpdateTime(new Date());
		BeanUtil.copyPropertiesWithoutNull(role, origin);
		roleRepository.save(role);
	}

	@Override
	public void deleteRole(RoleDeleteDto dto) {
		roleRepository.deleteById(dto.getId());
	}

	@Override
	public Role findRole(RoleQueryDto dto) {
		return roleRepository.findById(dto.getId()).get();
	}

	@Override
	public Page<Role> findRoles(RoleQueryDto dto) {
		PageRequest request = PageRequest.of(dto.getPageNumber(), dto.getPageSize());
		return roleRepository.findAll(request);
	}

}
