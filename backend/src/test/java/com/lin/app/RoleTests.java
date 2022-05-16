package com.lin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;

import com.google.common.collect.Lists;
import com.lin.controller.RoleController;
import com.lin.dto.ApiResult;
import com.lin.dto.RoleAddDto;
import com.lin.dto.RoleDeleteDto;
import com.lin.dto.RoleQueryDto;
import com.lin.dto.RoleUpdateDto;
import com.lin.entity.Role;
import com.lin.repository.RoleRepository;
import com.lin.util.UUIDUtil;

@SpringBootTest
public class RoleTests {

	@Autowired
	private RoleController roleController;

	@Autowired
	private RoleRepository roleRepository;

	@Test
	void addRole() {
		RoleAddDto addDto = new RoleAddDto();
		List<String> permission = Lists.newArrayList(UUIDUtil.getIdWithoutDashes(), UUIDUtil.getIdWithoutDashes());
		addDto.setName("Manager");
		addDto.setPermissionList(permission);
		roleController.addRole(addDto);
		int size = roleRepository.findAll().size();
		assertEquals(1, size);
		roleRepository.deleteAll();
	}

	@Test
	void updateRole() {
		addSingleRole();
		Role role = new Role();
		role.setName("Manager");
		role = roleRepository.findOne(Example.of(role)).get();
		RoleUpdateDto updateDto = new RoleUpdateDto();
		updateDto.setId(role.getId());
		List<String> permissions = Lists.newArrayList(UUIDUtil.getIdWithoutDashes(), UUIDUtil.getIdWithoutDashes());
		updateDto.setPermissionList(permissions);
		roleController.updateRole(updateDto);
		roleRepository.deleteAll();
	}

	@Test
	void deleteRole() {
		addSingleRole();
		String id = roleRepository.findAll().get(0).getId();
		RoleDeleteDto deleteDto = new RoleDeleteDto();
		deleteDto.setId(id);
		roleController.deleteRole(deleteDto);
	}

	@Test
	void findRoles() {
		addSingleRole();
		String id = roleRepository.findAll().get(0).getId();
		RoleQueryDto queryDto = new RoleQueryDto();
		queryDto.setId(id);
		ApiResult result = roleController.queryRoles(queryDto);
		Role role = (Role) result.getResponseBody();
		assertNotNull(role);
		addSingleRole();
		addSingleRole();
		queryDto.setId(null);
		result = roleController.queryRoles(queryDto);
		@SuppressWarnings("unchecked")
		Page<Role> rolePage = (Page<Role>) result.getResponseBody();
		int size = rolePage.getContent().size();
		assertEquals(3, size);
		roleRepository.deleteAll();
	}

	void addSingleRole() {
		RoleAddDto addDto = new RoleAddDto();
		List<String> permission = Lists.newArrayList(UUIDUtil.getIdWithoutDashes(), UUIDUtil.getIdWithoutDashes());
		addDto.setName("Manager");
		addDto.setPermissionList(permission);
		roleController.addRole(addDto);
	}
}
