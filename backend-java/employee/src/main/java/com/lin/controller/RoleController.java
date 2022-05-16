package com.lin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lin.dto.ApiResult;
import com.lin.dto.RoleAddDto;
import com.lin.dto.RoleDeleteDto;
import com.lin.dto.RoleQueryDto;
import com.lin.dto.RoleUpdateDto;
import com.lin.service.RoleService;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@PostMapping
	public ApiResult addRole(@RequestBody RoleAddDto dto) {
		roleService.addRole(dto);
		return ApiResult.ok();
	}

	@PutMapping
	public ApiResult updateRole(@RequestBody RoleUpdateDto dto) {
		roleService.updateRole(dto);
		return ApiResult.ok();
	}

	@DeleteMapping
	public ApiResult deleteRole(@RequestBody RoleDeleteDto dto) {
		roleService.deleteRole(dto);
		return ApiResult.ok();
	}

	@GetMapping
	public ApiResult queryRoles(RoleQueryDto dto) {
		if (StringUtils.hasText(dto.getId())) {
			return ApiResult.ok(roleService.findRole(dto));
		}
		return ApiResult.ok(roleService.findRoles(dto));
	}
}
