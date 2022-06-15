package com.lin.controllers;

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
import com.lin.dto.PermissionAddDto;
import com.lin.dto.PermissionDeleteDto;
import com.lin.dto.PermissionQueryDto;
import com.lin.dto.PermissionUpdateDto;
import com.lin.services.PermissionService;

@RestController
@RequestMapping(value = "/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	@PostMapping
	public ApiResult addPermission(@RequestBody PermissionAddDto dto) {
		permissionService.addPermission(dto);
		return ApiResult.ok();
	}

	@PutMapping
	public ApiResult updatePermission(@RequestBody PermissionUpdateDto dto) {
		permissionService.updatePermission(dto);
		return ApiResult.ok();
	}

	@DeleteMapping
	public ApiResult deletePermission(@RequestBody PermissionDeleteDto dto) {
		permissionService.deletePermission(dto);
		return ApiResult.ok();
	}

	@GetMapping
	public ApiResult queryPermissions(PermissionQueryDto dto) {
		if (StringUtils.hasText(dto.getId())) {
			return ApiResult.ok(permissionService.findPermission(dto));
		}
		return ApiResult.ok(permissionService.findPermissions(dto));
	}

}
