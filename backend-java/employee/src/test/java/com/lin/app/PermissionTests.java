package com.lin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import com.lin.controller.PermissionController;
import com.lin.dto.ApiResult;
import com.lin.dto.PermissionAddDto;
import com.lin.dto.PermissionQueryDto;
import com.lin.dto.PermissionUpdateDto;
import com.lin.entity.Permission;
import com.lin.mongo.repository.PermissionRepository;

@SpringBootTest
public class PermissionTests {

	@Autowired
	PermissionController permissionController;

	@Autowired
	PermissionRepository permissionRepository;

	@Autowired
	ModelMapper modelMapper;

	@Test
	void addPermission() {
		PermissionAddDto dto = new PermissionAddDto();
		dto.setName("Add an employee");
		dto.setLevel(1);
		ApiResult result = permissionController.addPermission(dto);
		assertEquals(result.getCode().toString(), "SUCCESS");
		Permission query = new Permission();
		query.setName("Add an employee");
		Boolean isPresent = permissionRepository.findOne(Example.of(query)).isPresent();
		assertTrue(isPresent);
		permissionRepository.deleteAll();
	}

	@Test
	void updatePermission() throws InterruptedException {
		PermissionAddDto addDto = new PermissionAddDto();
		addDto.setName("Add an employee");
		addDto.setLevel(1);
		permissionController.addPermission(addDto);
		Permission query = new Permission();
		query.setName("Add an employee");
		Permission permission = permissionRepository.findOne(Example.of(query)).get();
		PermissionUpdateDto dto = modelMapper.map(permission, PermissionUpdateDto.class);
		dto.setLevel(2);
		permissionController.updatePermission(dto);
		permission = permissionRepository.findAll().stream().findAny().get();
		assertEquals(permission.getLevel(), 2);
		permissionRepository.deleteAll();
	}

	@Test
	void queryPermissions() {
		PermissionAddDto dto = new PermissionAddDto();
		dto.setName("Add an employee");
		dto.setLevel(1);
		permissionController.addPermission(dto);
		dto.setName("Delete an employee");
		permissionController.addPermission(dto);
		dto.setName("Update an employee");
		permissionController.addPermission(dto);
		@SuppressWarnings("unchecked")
		List<Permission> permissions = (List<Permission>) permissionController
				.queryPermissions(new PermissionQueryDto()).getResponseBody();
		assertEquals(3, permissions.size());
		permissionRepository.deleteAll();
	}

	@Test
	void queryPermission() {
		PermissionAddDto dto = new PermissionAddDto();
		dto.setName("Add an employee");
		dto.setLevel(1);
		permissionController.addPermission(dto);
		@SuppressWarnings("unchecked")
		List<Permission> permissions = (List<Permission>) permissionController
				.queryPermissions(new PermissionQueryDto()).getResponseBody();
		String id = permissions.get(0).getId();
		PermissionQueryDto query = new PermissionQueryDto();
		query.setId(id);
		Permission permission = (Permission) permissionController.queryPermissions(query).getResponseBody();
		assertNotNull(permission);
		permissionRepository.deleteAll();
	}

}
